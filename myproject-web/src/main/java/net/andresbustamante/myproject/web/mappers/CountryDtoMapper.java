package net.andresbustamante.myproject.web.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import net.andresbustamante.myproject.api.model.CountryDto;
import net.andresbustamante.myproject.web.config.MapstructWebSpringConfig;
import net.andresbustamante.myproject.web.dto.Country;

@Mapper(config = MapstructWebSpringConfig.class)
public interface CountryDtoMapper {

    Country map(CountryDto country);

    List<Country> map(Collection<CountryDto> countries);
}
