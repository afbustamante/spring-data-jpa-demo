package net.andresbustamante.myproject.core.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.andresbustamante.myproject.api.model.ActorCreationDto;
import net.andresbustamante.myproject.api.model.ActorDto;
import net.andresbustamante.myproject.api.model.FilmCreationDto;
import net.andresbustamante.myproject.api.services.ActorManagementService;
import net.andresbustamante.myproject.api.services.FilmManagementService;
import net.andresbustamante.myproject.core.dao.ActorDao;
import net.andresbustamante.myproject.core.dao.CategoryDao;
import net.andresbustamante.myproject.core.dao.FilmDao;
import net.andresbustamante.myproject.core.dao.LanguageDao;
import net.andresbustamante.myproject.core.entities.Actor;
import net.andresbustamante.myproject.core.entities.Category;
import net.andresbustamante.myproject.core.entities.Film;
import net.andresbustamante.myproject.core.entities.FilmActor;
import net.andresbustamante.myproject.core.entities.FilmActorId;
import net.andresbustamante.myproject.core.entities.FilmCategory;
import net.andresbustamante.myproject.core.entities.FilmCategoryId;
import net.andresbustamante.myproject.core.mappers.FilmMapper;

@Service
@Slf4j
public class FilmManagementServiceImpl implements FilmManagementService {

    private final FilmDao filmDao;
    private final ActorDao actorDao;
    private final CategoryDao categoryDao;
    private final LanguageDao languageDao;
    private final FilmMapper filmMapper;
    private final ActorManagementService actorManagementService;

    public FilmManagementServiceImpl(FilmDao filmDao, ActorDao actorDao, CategoryDao categoryDao,
            LanguageDao languageDao, FilmMapper filmMapper,
            ActorManagementService actorManagementService) {
        this.filmDao = filmDao;
        this.actorDao = actorDao;
        this.categoryDao = categoryDao;
        this.languageDao = languageDao;
        this.filmMapper = filmMapper;
        this.actorManagementService = actorManagementService;
    }

    @Override
    @Transactional
    public int createFilm(final FilmCreationDto filmData) {
        Film film = filmMapper.map(filmData);
        film.setLanguage(languageDao.getReferenceById(filmData.languageId()));

        if (filmData.originalLanguageId() != null) {
            film.setOriginalLanguage(languageDao.getReferenceById(filmData.originalLanguageId()));
        }

        film = filmDao.save(film);

        setFilmActors(film, filmData);
        setFilmCategories(film, filmData);

        film = filmDao.save(film);

        log.info("New film {} created with the ID {}", film.getTitle(), film.getId());

        return film.getId();
    }

    private void setFilmCategories(final Film film, final FilmCreationDto filmData) {
        List<Category> categories = categoryDao.findAllById(filmData.categories());

        for (Category category : categories) {
            FilmCategory filmCategory = new FilmCategory();
            filmCategory.setId(new FilmCategoryId(film.getId(), category.getId()));
            filmCategory.setFilm(film);
            filmCategory.setCategory(category);

            film.getFilmCategories().add(filmCategory);
        }
    }

    private void setFilmActors(final Film film, final FilmCreationDto filmData) {
        List<Actor> actors = findOrCreateActors(filmData.actors());

        for (Actor actor : actors) {
            FilmActor filmActor = new FilmActor();
            filmActor.setId(new FilmActorId(actor.getId(), film.getId()));
            filmActor.setActor(actor);
            filmActor.setFilm(film);

            film.getFilmActors().add(filmActor);
        }
    }

    private List<Actor> findOrCreateActors(final Set<ActorDto> actors) {
        List<Short> actorsResult = new ArrayList<>();

        actors.forEach(actor -> {
            if (actor.getId() != null) {
                actorsResult.add(actor.getId());
            } else {
                short id = actorManagementService.createActor(
                        new ActorCreationDto(actor.getFirstName(), actor.getLastName()));

                actorsResult.add(id);
            }
        });

        return actorDao.findAllById(actorsResult);
    }
}
