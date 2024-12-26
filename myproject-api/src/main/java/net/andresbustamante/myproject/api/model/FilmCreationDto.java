package net.andresbustamante.myproject.api.model;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Set;

public record FilmCreationDto(
        String title, String description, Year releaseYear, Short languageId, Short originalLanguageId,
        Short rentalDuration, BigDecimal rentalRate, Short length, BigDecimal replacementCost, String rating,
        Set<ActorDto> actors, Set<Byte> categories,
        String specialFeatures) {
}
