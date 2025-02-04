package net.andresbustamante.myproject.web.controllers;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import net.andresbustamante.myproject.api.model.CategoryDto;
import net.andresbustamante.myproject.api.services.CategorySearchService;
import net.andresbustamante.myproject.web.dto.CategoryPage;
import net.andresbustamante.myproject.web.mappers.CategoryDtoMapper;

@RestController
@RequestMapping("/api")
public class CategoriesController extends AbstractController implements CategoriesApi {

    private final CategorySearchService categorySearchService;
    private final CategoryDtoMapper categoryDtoMapper;

    public CategoriesController(final ObjectMapper objectMapper, final HttpServletRequest request,
            final CategorySearchService categorySearchService,
            final CategoryDtoMapper categoryDtoMapper) {
        super(objectMapper, request);
        this.categorySearchService = categorySearchService;
        this.categoryDtoMapper = categoryDtoMapper;
    }

    @Override
    public ResponseEntity<CategoryPage> findCategories() {
        Collection<CategoryDto> categories = categorySearchService.findCategories();

        CategoryPage page = new CategoryPage();
        page.setPage(0);
        page.setNumberOfElements(categories.size());
        page.setTotalElements(categories.size());
        page.setCategories(categoryDtoMapper.map(categories));

        return ResponseEntity.ok(page);
    }
}
