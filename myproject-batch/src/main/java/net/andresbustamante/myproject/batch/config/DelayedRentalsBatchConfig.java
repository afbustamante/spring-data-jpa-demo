package net.andresbustamante.myproject.batch.config;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import javax.sql.DataSource;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.WritableResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

import net.andresbustamante.myproject.api.model.DelayedRentalDto;
import net.andresbustamante.myproject.batch.processors.DelayedRentalExportProcessor;

@Configuration
public class DelayedRentalsBatchConfig {

    @Value("${batchs.rentals.delay.export.chunk}")
    private int exportChunk;

    @Value("${batchs.rentals.delay.export.directory}")
    private File exportDir;

    @Bean
    public Job delayedRentalsJob(final JobRepository jobRepository, final Step delayedRentalsExportStep) {
        return new JobBuilder("delayed_rentals_job", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(delayedRentalsExportStep)
                    .on(ExitStatus.STOPPED.getExitCode()).stop()
                    .on(ExitStatus.UNKNOWN.getExitCode()).fail()
                    .on(ExitStatus.FAILED.getExitCode()).fail()
                    .on(ExitStatus.COMPLETED.getExitCode()).end()
                .end()
                .build();
    }

    @Bean
    public Step delayedRentalsExportStep(final JobRepository jobRepository,
            final PlatformTransactionManager transactionManager,
            final ItemReader<DelayedRentalDto> delayedRentalsExportItemReader,
            final ItemProcessor<DelayedRentalDto, DelayedRentalDto> delayedRentalsExportItemProcessor,
            final ItemWriter<DelayedRentalDto> delayedRentalsExportItemWriter) {
        return new StepBuilder("delayed_rentals_export_step", jobRepository)
                .<DelayedRentalDto, DelayedRentalDto> chunk(10, transactionManager)
                .reader(delayedRentalsExportItemReader)
                .processor(delayedRentalsExportItemProcessor)
                .writer(delayedRentalsExportItemWriter)
                .allowStartIfComplete(true)
                .build();
    }

    @Bean
    public JdbcCursorItemReader<DelayedRentalDto> delayedRentalsExportItemReader(final DataSource dataSource) {
        JdbcCursorItemReader<DelayedRentalDto> itemReader = new JdbcCursorItemReader<>();
        itemReader.setSql("""
            select
            	r.rental_id as rentalId,
            	f.title as filmTitle,
            	r.rental_date as rentalDate,
            	f.rental_duration as filmRentalDuration,
            	c.first_name as customerFirstName,
            	c.last_name as customerLastName,
            	c.email as customerEmail,
            	c.active as customerActive
            from
            	rental r
            inner join inventory i on
            	r.inventory_id = i.inventory_id
            inner join customer c on
            	r.customer_id = c.customer_id
            inner join film f on
            	i.film_id = f.film_id
            where
            	r.return_date is null
        """);
        itemReader.setRowMapper(new BeanPropertyRowMapper<>());
        itemReader.setDataSource(dataSource);
        itemReader.setFetchSize(exportChunk);
        return itemReader;
    }

    @Bean
    public ItemProcessor<DelayedRentalDto, DelayedRentalDto> delayedRentalsExportItemProcessor() {
        return new DelayedRentalExportProcessor();
    }

    @Bean
    public ItemWriter<DelayedRentalDto> delayedRentalsExportItemWriter() {
        DelimitedLineAggregator<DelayedRentalDto> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setDelimiter(",");

        WritableResource outputResource = new FileSystemResource(
                Path.of(String.join(File.separator, exportDir.getAbsolutePath(), "delayed_rentals_export.csv")));

        FlatFileItemWriter<DelayedRentalDto> itemWriter = new FlatFileItemWriter<>();
        itemWriter.setName("delayed_rentals_export.csv");
        itemWriter.setAppendAllowed(true);
        itemWriter.setLineAggregator(lineAggregator);
        itemWriter.setEncoding(StandardCharsets.UTF_8.displayName());
        itemWriter.setResource(outputResource);
        return itemWriter;
    }
}
