package net.andresbustamante.myproject.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmItemDto {

    private Short id;
    private String title;

    @JsonProperty("release_year")
    private Short releaseYear;

    private Integer length;
    private String rating;
}
