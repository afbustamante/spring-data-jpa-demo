package net.andresbustamante.myproject.api.services;

import java.util.Collection;

import net.andresbustamante.myproject.api.model.CategoryDto;

public interface CategorySearchService {

    Collection<CategoryDto> findCategories();
}
