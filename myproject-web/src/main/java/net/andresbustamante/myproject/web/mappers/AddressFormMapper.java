package net.andresbustamante.myproject.web.mappers;

import org.mapstruct.Mapper;

import net.andresbustamante.myproject.api.model.AddressCreationDto;
import net.andresbustamante.myproject.web.config.MapstructWebSpringConfig;
import net.andresbustamante.myproject.web.dto.AddressForm;

@Mapper(config = MapstructWebSpringConfig.class)
public interface AddressFormMapper {

    AddressCreationDto map(AddressForm form);
}
