package net.andresbustamante.myproject.core.mappers;

import java.time.Year;

import org.mapstruct.Mapper;

import net.andresbustamante.myproject.core.config.MapstructSpringConfig;

@Mapper(config = MapstructSpringConfig.class)
public interface DateMapper {

    default Short map(Year year) {
        return year != null ? (short) year.getValue() : null;
    }
}
