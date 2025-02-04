package net.andresbustamante.myproject.api.model;

import java.time.Instant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ActorDto extends PersonDto {

    private Short id;
    private Instant lastUpdate;

    public ActorDto(final String firstName, final String lastName) {
        super(firstName, lastName);
    }
}
