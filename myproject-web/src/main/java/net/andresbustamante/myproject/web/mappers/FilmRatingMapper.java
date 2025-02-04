package net.andresbustamante.myproject.web.mappers;

import org.mapstruct.Mapper;

import net.andresbustamante.myproject.web.config.MapstructWebSpringConfig;
import net.andresbustamante.myproject.web.dto.FilmRating;

@Mapper(config = MapstructWebSpringConfig.class)
public interface FilmRatingMapper {

    default FilmRating map(String value) {
        if (value != null) {
            return FilmRating.fromValue(value);
        }
        return null;
    }
}
