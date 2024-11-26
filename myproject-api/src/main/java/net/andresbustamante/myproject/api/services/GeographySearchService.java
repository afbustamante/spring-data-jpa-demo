package net.andresbustamante.myproject.api.services;

import java.util.Collection;

import net.andresbustamante.myproject.api.model.CityDto;
import net.andresbustamante.myproject.api.model.CountryDto;

public interface GeographySearchService {

    Collection<CountryDto> findCountries();

    Collection<CityDto> findCitiesByCountry(Short countryId);
}
