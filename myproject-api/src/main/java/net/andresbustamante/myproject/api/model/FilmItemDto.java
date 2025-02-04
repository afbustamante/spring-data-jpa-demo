package net.andresbustamante.myproject.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmItemDto {

    private Short id;
    private String title;
    private Short releaseYear;
    private Integer length;
    private String rating;
}
