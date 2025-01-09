package net.andresbustamante.myproject.api.model;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {

    private Byte id;
    private String name;
    private Instant lastUpdate;
}
