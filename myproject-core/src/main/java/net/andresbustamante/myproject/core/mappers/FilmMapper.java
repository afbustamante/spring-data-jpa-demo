package net.andresbustamante.myproject.core.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.myproject.api.model.FilmCreationDto;
import net.andresbustamante.myproject.api.model.FilmItemDto;
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

    FilmItemDto map(Film film);

    List<FilmItemDto> map(Collection<Film> films);
}
