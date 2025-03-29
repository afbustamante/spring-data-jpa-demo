package net.andresbustamante.myproject.core.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class Person extends AuditableEntity {

    @NotNull
    @Size(max = 45)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(max = 45)
    @Column(name = "last_name")
    private String lastName;

    @Transient
    public String getFullName() {
        return String.join(StringUtils.SPACE, firstName, lastName);
    }
}
