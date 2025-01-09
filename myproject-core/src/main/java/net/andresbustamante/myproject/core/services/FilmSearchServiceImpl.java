package net.andresbustamante.myproject.core.services;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.myproject.api.model.FilmItemDto;
import net.andresbustamante.myproject.api.model.FilmSearchDto;
import net.andresbustamante.myproject.api.services.FilmSearchService;
import net.andresbustamante.myproject.core.dao.FilmDao;
import net.andresbustamante.myproject.core.entities.Film;
import net.andresbustamante.myproject.core.mappers.FilmMapper;
import net.andresbustamante.myproject.core.util.FilmSearchSpecification;

@Service
@Transactional(readOnly = true)
public class FilmSearchServiceImpl implements FilmSearchService {

    private final FilmDao filmDao;
    private final FilmMapper filmMapper;

    public FilmSearchServiceImpl(final FilmDao filmDao, final FilmMapper filmMapper) {
        this.filmDao = filmDao;
        this.filmMapper = filmMapper;
    }

    @Override
    public Collection<FilmItemDto> findFilms(final FilmSearchDto criteria) {
        List<Film> films = criteria.isEmpty() ? filmDao.findAll() : filmDao.findAll(
                new FilmSearchSpecification(criteria), Sort.by("title"));
        return filmMapper.map(films);
    }
}
