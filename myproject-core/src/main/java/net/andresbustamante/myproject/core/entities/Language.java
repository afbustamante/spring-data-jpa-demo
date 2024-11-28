package net.andresbustamante.myproject.core.entities;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "language")
@Getter
@Setter
public class Language implements Serializable {

    @Id
    @Column(name = "language_id")
    private Short id;

    @Size(max = 20)
    @NotNull
    private String name;

    @NotNull
    @Column(name = "last_update")
    private Instant lastUpdate;

}