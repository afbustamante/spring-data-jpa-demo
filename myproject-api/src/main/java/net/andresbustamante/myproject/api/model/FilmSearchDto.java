package net.andresbustamante.myproject.api.model;

import java.time.Year;

import org.apache.commons.lang3.StringUtils;

public record FilmSearchDto(String title, Year releaseYear, String rating, Short languageId) {

    public boolean isEmpty() {
        return StringUtils.isEmpty(title) || releaseYear == null || StringUtils.isEmpty(rating) || languageId == null;
    }
}
