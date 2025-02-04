package net.andresbustamante.myproject.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import net.andresbustamante.myproject.api.model.FilmSearchDto;
import net.andresbustamante.myproject.core.entities.Film;
import net.andresbustamante.myproject.core.entities.Language;

public class FilmSearchSpecification implements Specification<Film> {

    private final FilmSearchDto criteria;

    public FilmSearchSpecification(final FilmSearchDto criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(final Root<Film> root, final CriteriaQuery<?> query,
            final CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (criteria.title() != null) {
            predicates.add(criteriaBuilder.like(root.get("title"), "%" + criteria.title() + "%"));
        }

        if (criteria.releaseYear() != null) {
            predicates.add(criteriaBuilder.equal(root.get("releaseYear"), criteria.releaseYear().getValue()));
        }

        if (criteria.rating() != null) {
            predicates.add(criteriaBuilder.equal(root.get("rating"), criteria.rating()));
        }

        if (criteria.language() != null) {
            Join<Film, Language> languageJoin = root.join("language");
            predicates.add(criteriaBuilder.equal(languageJoin.get("name"), criteria.language()));
        }

        return predicates.stream().reduce(criteriaBuilder::and).orElse(null);
    }
}
