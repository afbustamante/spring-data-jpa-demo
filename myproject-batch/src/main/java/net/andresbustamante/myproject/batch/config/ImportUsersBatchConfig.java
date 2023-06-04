package net.andresbustamante.myproject.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import net.andresbustamante.myproject.api.entities.users.User;
import net.andresbustamante.myproject.batch.dto.ImportedUser;
import net.andresbustamante.myproject.batch.processors.ImportUserProcessor;
import net.andresbustamante.myproject.core.repositories.UserRepository;

@Configuration
public class ImportUsersBatchConfig {

    @Bean
    public ItemReader<ImportedUser> importedUsersReader() {
        FlatFileItemReader<ImportedUser> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("users.csv"));
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[] { "first_name", "surname", "email", "gender" });
                    }
                });

                setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {
                    {
                        setTargetType(ImportedUser.class);
                    }
                });
            }
        });
        return reader;
    }

    @Bean
    public ItemProcessor<ImportedUser, User> importedUsersProcessor(UserRepository userRepository) {
        return new ImportUserProcessor(userRepository);
    }

    @Bean
    public ItemWriter<User> importedUsersWriter(UserRepository userRepository) {
        RepositoryItemWriter<User> writer = new RepositoryItemWriter<>();
        writer.setRepository(userRepository);
        return writer;
    }

    @Bean
    public Job importUsersJob(JobBuilderFactory jobBuilderFactory, Step importUsersFromCsvFileStep) {
        return jobBuilderFactory.get("import_users")
                .incrementer(new RunIdIncrementer())
                .flow(importUsersFromCsvFileStep)
                .end()
                .build();
    }

    @Bean
    public Step importUsersFromCsvFileStep(StepBuilderFactory stepBuilderFactory, ItemReader<ImportedUser> importedUsersReader,
            ItemWriter<User> importedUsersWriter, ItemProcessor<ImportedUser, User> importedUsersProcessor) {
        return stepBuilderFactory.get("import_users_from_csv_file")
                .<ImportedUser, User>chunk(10)
                .reader(importedUsersReader)
                .processor(importedUsersProcessor)
                .writer(importedUsersWriter)
                .build();
    }
}
