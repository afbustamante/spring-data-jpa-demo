package net.andresbustamante.myproject.api.services;

import net.andresbustamante.myproject.api.model.FilmCreationDto;

public interface FilmManagementService {

    /**
     * Creates a new film in database.
     *
     * @param filmData Data to use to create the film.
     * @return New film's ID
     */
    int createFilm(FilmCreationDto filmData);
}
