package net.andresbustamante.myproject.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PersonDto {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    public PersonDto(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
