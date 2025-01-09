package net.andresbustamante.myproject.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import net.andresbustamante.myproject.core.entities.Film;

public interface FilmDao extends JpaRepository<Film, Integer>, JpaSpecificationExecutor<Film> {
}
