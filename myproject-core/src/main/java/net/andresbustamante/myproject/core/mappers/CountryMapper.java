package net.andresbustamante.myproject.core.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.myproject.api.model.CountryDto;
import net.andresbustamante.myproject.core.config.MapstructSpringConfig;
import net.andresbustamante.myproject.core.entities.Country;

@Mapper(config = MapstructSpringConfig.class)
public interface CountryMapper {

    @Mapping(target = "cities", ignore = true)
    CountryDto map(Country country);

    List<CountryDto> map(Collection<Country> countries);
}
