package net.andresbustamante.myproject.api.services;

import net.andresbustamante.myproject.api.model.FilmCreationDto;
import net.andresbustamante.myproject.api.util.UserContext;

public interface FilmManagementService {

    /**
     * Creates a new film in database.
     *
     * @param filmData Data to use to create the film.
     * @param ctx Context of the current user.
     * @return New film's ID
     */
    int createFilm(FilmCreationDto filmData, UserContext ctx);
}
