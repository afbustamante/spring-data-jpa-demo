package net.andresbustamante.myproject.web.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import net.andresbustamante.myproject.api.model.FilmItemDto;
import net.andresbustamante.myproject.web.config.MapstructWebSpringConfig;
import net.andresbustamante.myproject.web.dto.Film;

@Mapper(config = MapstructWebSpringConfig.class, uses = FilmRatingMapper.class)
public interface FilmDtoMapper {

    Film map(FilmItemDto film);

    List<Film> map(Collection<FilmItemDto> films);
}
