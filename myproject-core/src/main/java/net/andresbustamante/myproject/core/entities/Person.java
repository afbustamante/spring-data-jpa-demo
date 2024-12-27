package net.andresbustamante.myproject.core.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class Person implements Serializable {

    @NotNull
    @Size(max = 45)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(max = 45)
    @Column(name = "last_name")
    private String lastName;
}
