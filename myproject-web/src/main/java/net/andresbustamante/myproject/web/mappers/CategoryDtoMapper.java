package net.andresbustamante.myproject.web.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import net.andresbustamante.myproject.api.model.CategoryDto;
import net.andresbustamante.myproject.web.config.MapstructWebSpringConfig;
import net.andresbustamante.myproject.web.dto.Category;

@Mapper(config = MapstructWebSpringConfig.class)
public interface CategoryDtoMapper {

    Category map(CategoryDto category);

    List<Category> map(Collection<CategoryDto> categories);
}
