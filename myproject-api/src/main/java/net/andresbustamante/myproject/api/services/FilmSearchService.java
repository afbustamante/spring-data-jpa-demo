package net.andresbustamante.myproject.api.services;

import java.util.Collection;

import net.andresbustamante.myproject.api.model.FilmItemDto;
import net.andresbustamante.myproject.api.model.FilmSearchDto;

public interface FilmSearchService {

    Collection<FilmItemDto> findFilms(FilmSearchDto criteria);
}
