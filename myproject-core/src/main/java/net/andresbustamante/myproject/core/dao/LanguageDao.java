package net.andresbustamante.myproject.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.myproject.core.entities.Language;

public interface LanguageDao extends JpaRepository<Language, Short> {
}
