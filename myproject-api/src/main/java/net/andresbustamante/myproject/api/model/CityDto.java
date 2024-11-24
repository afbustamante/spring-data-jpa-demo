package net.andresbustamante.myproject.api.model;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDto {

    private Short id;

    private String name;

    @JsonIgnore
    private CountryDto country;

    private Instant lastUpdate;
}
