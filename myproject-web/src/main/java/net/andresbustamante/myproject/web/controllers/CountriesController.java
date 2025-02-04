package net.andresbustamante.myproject.web.controllers;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import net.andresbustamante.myproject.api.model.CityDto;
import net.andresbustamante.myproject.api.model.CountryDto;
import net.andresbustamante.myproject.api.services.GeographySearchService;
import net.andresbustamante.myproject.web.dto.CityPage;
import net.andresbustamante.myproject.web.dto.CountryPage;
import net.andresbustamante.myproject.web.mappers.CityDtoMapper;
import net.andresbustamante.myproject.web.mappers.CountryDtoMapper;

@RestController
@RequestMapping("/api")
public class CountriesController extends AbstractController implements CountriesApi {

    private final GeographySearchService geographySearchService;
    private final CountryDtoMapper countryDtoMapper;
    private final CityDtoMapper cityDtoMapper;

    public CountriesController(final ObjectMapper objectMapper, final HttpServletRequest request,
            final GeographySearchService geographySearchService, final CountryDtoMapper countryDtoMapper,
            final CityDtoMapper cityDtoMapper) {
        super(objectMapper, request);
        this.geographySearchService = geographySearchService;
        this.countryDtoMapper = countryDtoMapper;
        this.cityDtoMapper = cityDtoMapper;
    }

    @Override
    public ResponseEntity<CountryPage> findCountries() {
        Collection<CountryDto> countries = geographySearchService.findCountries();

        CountryPage countryPage = new CountryPage();
        countryPage.setPage(0);
        countryPage.setNumberOfElements(countries.size());
        countryPage.setTotalElements(countries.size());
        countryPage.setCountries(countryDtoMapper.map(countries));

        return ResponseEntity.ok(countryPage);
    }

    @Override
    public ResponseEntity<CityPage> findCitiesByCountry(Integer id) {
        Collection<CityDto> cities = geographySearchService.findCitiesByCountry(id.shortValue());

        CityPage cityPage = new CityPage();
        cityPage.setPage(0);
        cityPage.setNumberOfElements(cities.size());
        cityPage.setTotalElements(cities.size());
        cityPage.setCities(cityDtoMapper.map(cities));

        return ResponseEntity.ok(cityPage);
    }
}
