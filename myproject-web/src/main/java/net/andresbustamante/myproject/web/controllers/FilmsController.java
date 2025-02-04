package net.andresbustamante.myproject.web.controllers;

import java.time.Year;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import net.andresbustamante.myproject.api.model.FilmItemDto;
import net.andresbustamante.myproject.api.model.FilmSearchDto;
import net.andresbustamante.myproject.api.services.FilmSearchService;
import net.andresbustamante.myproject.web.dto.FilmPage;
import net.andresbustamante.myproject.web.dto.FilmRating;
import net.andresbustamante.myproject.web.mappers.FilmDtoMapper;

@RestController
@RequestMapping("/api")
public class FilmsController extends AbstractController implements FilmsApi {

    private final FilmSearchService filmSearchService;
    private final FilmDtoMapper filmDtoMapper;

    public FilmsController(final ObjectMapper objectMapper, final HttpServletRequest request,
            final FilmSearchService filmSearchService, final FilmDtoMapper filmDtoMapper) {
        super(objectMapper, request);
        this.filmSearchService = filmSearchService;
        this.filmDtoMapper = filmDtoMapper;
    }

    @Override
    public ResponseEntity<FilmPage> findFilms(final String title, final Integer year, final FilmRating rating,
            final String language) {
        Year releaseYear = year != null ? Year.of(year) : null;
        FilmSearchDto criteria = new FilmSearchDto(title, releaseYear, rating.toString(), language);

        Collection<FilmItemDto> films = filmSearchService.findFilms(criteria);

        FilmPage filmPage = new FilmPage();
        filmPage.setPage(0);
        filmPage.setNumberOfElements(films.size());
        filmPage.setTotalElements(films.size());
        filmPage.setFilms(filmDtoMapper.map(films));

        return ResponseEntity.ok(filmPage);
    }
}
