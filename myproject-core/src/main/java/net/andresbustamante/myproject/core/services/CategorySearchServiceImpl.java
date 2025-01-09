package net.andresbustamante.myproject.core.services;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.myproject.api.model.CategoryDto;
import net.andresbustamante.myproject.api.services.CategorySearchService;
import net.andresbustamante.myproject.core.dao.CategoryDao;
import net.andresbustamante.myproject.core.entities.Category;
import net.andresbustamante.myproject.core.mappers.CategoryMapper;

@Service
@Transactional(readOnly = true)
public class CategorySearchServiceImpl implements CategorySearchService {

    private final CategoryDao categoryDao;
    private final CategoryMapper categoryMapper;

    public CategorySearchServiceImpl(final CategoryDao categoryDao, final CategoryMapper categoryMapper) {
        this.categoryDao = categoryDao;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Collection<CategoryDto> findCategories() {
        List<Category> categories = categoryDao.findAll(Sort.by("name"));
        return categoryMapper.map(categories);
    }
}
