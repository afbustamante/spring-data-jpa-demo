package net.andresbustamante.myproject.web.mappers;

import org.mapstruct.Mapper;

import net.andresbustamante.myproject.api.model.StaffCreationDto;
import net.andresbustamante.myproject.web.config.MapstructWebSpringConfig;
import net.andresbustamante.myproject.web.dto.StaffForm;

@Mapper(config = MapstructWebSpringConfig.class, uses = AddressFormMapper.class)
public interface StaffFormMapper {

    StaffCreationDto map(StaffForm form);
}
