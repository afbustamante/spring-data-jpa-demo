package net.andresbustamante.myproject.core.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.myproject.api.model.AddressDto;
import net.andresbustamante.myproject.core.config.MapstructSpringConfig;
import net.andresbustamante.myproject.core.entities.Address;

@Mapper(config = MapstructSpringConfig.class)
public interface AddressMapper {

    @Mapping(target = "city", source = "city.name")
    @Mapping(target = "country", source = "city.country.name")
    AddressDto map(Address address);
}
