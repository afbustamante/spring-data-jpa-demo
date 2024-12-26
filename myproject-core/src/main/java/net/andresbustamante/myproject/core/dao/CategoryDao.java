package net.andresbustamante.myproject.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.myproject.core.entities.Category;

public interface CategoryDao extends JpaRepository<Category, Byte> {
}
