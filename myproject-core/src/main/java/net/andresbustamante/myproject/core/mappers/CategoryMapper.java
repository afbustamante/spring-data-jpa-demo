package net.andresbustamante.myproject.core.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import net.andresbustamante.myproject.api.model.CategoryDto;
import net.andresbustamante.myproject.core.config.MapstructSpringConfig;
import net.andresbustamante.myproject.core.entities.Category;

@Mapper(config = MapstructSpringConfig.class)
public interface CategoryMapper {

    CategoryDto map(Category category);

    List<CategoryDto> map(Collection<Category> categories);
}
