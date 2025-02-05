package net.andresbustamante.myproject.api.services;

import java.util.Collection;

import net.andresbustamante.myproject.api.model.FilmDto;
import net.andresbustamante.myproject.api.model.FilmSearchDto;

public interface FilmSearchService {

    Collection<FilmDto> findFilms(FilmSearchDto criteria);
}
