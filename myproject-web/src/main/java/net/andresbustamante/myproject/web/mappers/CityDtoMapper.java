package net.andresbustamante.myproject.web.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import net.andresbustamante.myproject.api.model.CityDto;
import net.andresbustamante.myproject.web.config.MapstructWebSpringConfig;
import net.andresbustamante.myproject.web.dto.City;

@Mapper(config = MapstructWebSpringConfig.class)
public interface CityDtoMapper {

    City map(CityDto city);

    List<City> map(Collection<CityDto> cities);
}
