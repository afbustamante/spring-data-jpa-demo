package net.andresbustamante.myproject.core.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.myproject.api.model.CityDto;
import net.andresbustamante.myproject.core.config.MapstructSpringConfig;
import net.andresbustamante.myproject.core.entities.City;

@Mapper(config = MapstructSpringConfig.class)
public interface CityMapper {

    @Mapping(target = "country", ignore = true)
    CityDto map(City city);

    List<CityDto> map(Collection<City> cities);
}
