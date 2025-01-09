package net.andresbustamante.myproject.web.controllers;

import static org.springframework.http.MediaType.*;

import java.time.Year;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.andresbustamante.myproject.api.model.FilmItemDto;
import net.andresbustamante.myproject.api.model.FilmSearchDto;
import net.andresbustamante.myproject.api.services.FilmSearchService;

@RestController
@RequestMapping("/api/films")
public class FilmsController {

    private final FilmSearchService filmSearchService;

    public FilmsController(final FilmSearchService filmSearchService) {
        this.filmSearchService = filmSearchService;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<FilmItemDto>> findFilms(
            @RequestParam(name = "title", required = false) final String title,
            @RequestParam(name = "year", required = false) final Short year,
            @RequestParam(name = "rating", required = false) final String rating,
            @RequestParam(name = "lang_id", required = false) final Short languageId) {
        Year releaseYear = year != null ? Year.of(year) : null;
        FilmSearchDto criteria = new FilmSearchDto(title, releaseYear, rating, languageId);

        return ResponseEntity.ok(filmSearchService.findFilms(criteria));
    }
}
