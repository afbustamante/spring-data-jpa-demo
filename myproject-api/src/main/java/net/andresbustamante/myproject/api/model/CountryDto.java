package net.andresbustamante.myproject.api.model;

import java.time.Instant;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryDto {

    private Short id;
    private String name;
    private Instant lastUpdate;
    private Set<CityDto> cities;
}
