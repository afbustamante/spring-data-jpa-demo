package net.andresbustamante.myproject.web.controllers;

import static org.springframework.http.MediaType.*;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.andresbustamante.myproject.api.model.CityDto;
import net.andresbustamante.myproject.api.model.CountryDto;
import net.andresbustamante.myproject.api.services.GeographySearchService;

@RestController
@RequestMapping("/api/countries")
public class CountriesController {

    private final GeographySearchService geographySearchService;

    public CountriesController(GeographySearchService geographySearchService) {
        this.geographySearchService = geographySearchService;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<CountryDto>> findCountries() {
        Collection<CountryDto> countries = geographySearchService.findCountries();
        return ResponseEntity.ok(countries);
    }

    @GetMapping(value = "/{id}/cities", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<CityDto>> findCitiesByCountry(@PathVariable("id") Short id) {
        Collection<CityDto> cities = geographySearchService.findCitiesByCountry(id);
        return ResponseEntity.ok(cities);
    }
}
