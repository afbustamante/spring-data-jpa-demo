package net.andresbustamante.myproject.web.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import net.andresbustamante.myproject.api.model.StaffDto;
import net.andresbustamante.myproject.web.config.MapstructWebSpringConfig;
import net.andresbustamante.myproject.web.dto.Staff;

@Mapper(config = MapstructWebSpringConfig.class)
public interface StaffDtoMapper {

    Staff map(StaffDto staff);

    List<Staff> map(Collection<StaffDto> staff);
}
