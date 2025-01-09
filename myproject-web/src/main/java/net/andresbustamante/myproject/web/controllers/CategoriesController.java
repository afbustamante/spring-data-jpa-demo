package net.andresbustamante.myproject.web.controllers;

import static org.springframework.http.MediaType.*;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.andresbustamante.myproject.api.model.CategoryDto;
import net.andresbustamante.myproject.api.services.CategorySearchService;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    private final CategorySearchService categorySearchService;

    public CategoriesController(final CategorySearchService categorySearchService) {
        this.categorySearchService = categorySearchService;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<CategoryDto>> findCategories() {
        return ResponseEntity.ok(categorySearchService.findCategories());
    }
}
