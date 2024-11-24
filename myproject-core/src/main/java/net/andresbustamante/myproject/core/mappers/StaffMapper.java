package net.andresbustamante.myproject.core.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import net.andresbustamante.myproject.api.model.StaffDto;
import net.andresbustamante.myproject.core.config.MapstructSpringConfig;
import net.andresbustamante.myproject.core.entities.Staff;

@Mapper(config = MapstructSpringConfig.class)
public interface StaffMapper {

    StaffDto map(Staff staff);

    List<StaffDto> map(Collection<Staff> staff);
}
