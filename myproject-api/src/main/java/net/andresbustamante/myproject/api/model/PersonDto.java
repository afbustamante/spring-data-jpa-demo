package net.andresbustamante.myproject.api.model;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PersonDto {

    private String firstName;
    private String lastName;

    public PersonDto(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return String.join(StringUtils.SPACE, firstName, lastName);
    }
}
