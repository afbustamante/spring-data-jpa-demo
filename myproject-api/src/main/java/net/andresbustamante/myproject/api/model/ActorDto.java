package net.andresbustamante.myproject.api.model;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActorDto extends PersonDto {

    private Integer id;

    @JsonProperty("updated_at")
    private Instant lastUpdate;
}
