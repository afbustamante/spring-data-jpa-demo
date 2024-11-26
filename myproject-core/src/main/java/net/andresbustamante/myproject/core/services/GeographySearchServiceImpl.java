package net.andresbustamante.myproject.core.services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.myproject.api.model.CityDto;
import net.andresbustamante.myproject.api.model.CountryDto;
import net.andresbustamante.myproject.api.services.GeographySearchService;
import net.andresbustamante.myproject.core.dao.CityDao;
import net.andresbustamante.myproject.core.dao.CountryDao;
import net.andresbustamante.myproject.core.entities.City;
import net.andresbustamante.myproject.core.entities.Country;
import net.andresbustamante.myproject.core.mappers.CityMapper;
import net.andresbustamante.myproject.core.mappers.CountryMapper;

@Service
@Transactional(readOnly = true)
public class GeographySearchServiceImpl implements GeographySearchService {

    private final CountryDao countryDao;
    private final CityDao cityDao;
    private final CountryMapper countryMapper;
    private final CityMapper cityMapper;

    public GeographySearchServiceImpl(CountryDao countryDao, CityDao cityDao, CountryMapper countryMapper,
            CityMapper cityMapper) {
        this.countryDao = countryDao;
        this.cityDao = cityDao;
        this.countryMapper = countryMapper;
        this.cityMapper = cityMapper;
    }

    @Override
    public Collection<CountryDto> findCountries() {
        Collection<Country> countries = countryDao.findAll();
        return countryMapper.map(countries);
    }

    @Override
    public Collection<CityDto> findCitiesByCountry(final Short countryId) {
        Collection<City> cities = cityDao.findByCountryId(countryId);
        return cityMapper.map(cities);
    }
}
