package net.andresbustamante.myproject.core.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import net.andresbustamante.myproject.api.model.ActorDto;
import net.andresbustamante.myproject.api.model.FilmCreationDto;
import net.andresbustamante.myproject.api.services.FilmManagementService;
import net.andresbustamante.myproject.core.config.CoreDaoTestConfig;
import net.andresbustamante.myproject.core.config.FilmManagementServiceTestConfig;
import net.andresbustamante.myproject.core.dao.FilmDao;
import net.andresbustamante.myproject.core.entities.Film;

@DataJpaTest
@ContextConfiguration(classes = {
        CoreDaoTestConfig.class,
        FilmManagementServiceTestConfig.class
})
class FilmManagementServiceImplIT {

    @Autowired
    private FilmManagementService filmManagementService;

    @Autowired
    private FilmDao filmDao;

    @Test
    void testCreateFilm() {
        // Given
        Set<ActorDto> actors = Set.of(new ActorDto("Tom", "Cruise"), new ActorDto("Val", "Kilmer"));
        Set<Byte> categories = Set.of((byte) 1, (byte) 7);
        Year releaseYear = Year.of(1986);

        FilmCreationDto filmCreationDto = new FilmCreationDto("Top Gun", "A film about planes", releaseYear,
                (short) 1, (short) 1, (short) 24, BigDecimal.TEN, null, BigDecimal.ONE, null,
                actors, categories, null);

        // When
        int filmId = filmManagementService.createFilm(filmCreationDto);

        // Then
        assertTrue(filmId > 0);

        Film film = filmDao.findById(filmId).orElseThrow();
        assertEquals("Top Gun", film.getTitle());
        assertEquals(2, film.getFilmActors().size());
        assertEquals(2, film.getFilmCategories().size());
    }
}