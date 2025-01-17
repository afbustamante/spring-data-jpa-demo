package net.andresbustamante.myproject.batch.processors;

import java.time.Instant;

import org.springframework.batch.item.ItemProcessor;

import net.andresbustamante.myproject.api.model.DelayedRentalDto;

public class DelayedRentalExportProcessor implements ItemProcessor<DelayedRentalDto, DelayedRentalDto> {

    @Override
    public DelayedRentalDto process(final DelayedRentalDto item) {
        long currentTimestamp = Instant.now().getEpochSecond();
        long rentalTimestamp = item.getRentalDate().getEpochSecond();
        long rentalDurationSeconds = currentTimestamp - rentalTimestamp;
        long rentalDurationDays = rentalDurationSeconds / (24 * 60 * 60 * 1000);
        long filmRentalDuration = (long) item.getFilmRentalDuration();
        long delay = rentalDurationDays - filmRentalDuration;

        item.setTotalRentalDuration((int) rentalDurationDays);
        item.setDelay((int) delay);

        return delay > 0L ? item : null;
    }
}
