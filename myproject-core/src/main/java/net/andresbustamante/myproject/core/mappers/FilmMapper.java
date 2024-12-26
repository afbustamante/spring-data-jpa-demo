package net.andresbustamante.myproject.core.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.myproject.api.model.FilmCreationDto;
import net.andresbustamante.myproject.core.config.MapstructSpringConfig;
import net.andresbustamante.myproject.core.entities.Film;

@Mapper(config = MapstructSpringConfig.class, uses = DateMapper.class)
public interface FilmMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "language", ignore = true)
    @Mapping(target = "originalLanguage", ignore = true)
    @Mapping(target = "lastUpdate", ignore = true)
    @Mapping(target = "filmActors", ignore = true)
    @Mapping(target = "filmCategories", ignore = true)
    Film map(FilmCreationDto creationDto);
}
