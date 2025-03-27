package net.andresbustamante.myproject.core.mappers;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import net.andresbustamante.myproject.api.model.StoreDto;
import net.andresbustamante.myproject.core.config.MapstructSpringConfig;
import net.andresbustamante.myproject.core.entities.Store;

@Mapper(config = MapstructSpringConfig.class, uses = {StaffMapper.class, AddressMapper.class})
public interface StoreMapper {

    StoreDto map(Store store);

    List<StoreDto> map(Collection<Store> stores);
}
