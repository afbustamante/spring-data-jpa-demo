package net.andresbustamante.myproject.web.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.andresbustamante.myproject.api.model.StoreDto;
import net.andresbustamante.myproject.web.config.MapstructWebSpringConfig;
import net.andresbustamante.myproject.web.dto.Store;

@Mapper(config = MapstructWebSpringConfig.class)
public interface StoreDtoMapper {

    @Mapping(target = "managerName", source = "manager.fullName")
    Store map(StoreDto store);

    List<Store> map(Collection<StoreDto> stores);
}
