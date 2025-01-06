package net.andresbustamante.myproject.core.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.springframework.cache.annotation.Cacheable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "language", uniqueConstraints = {
        @UniqueConstraint(name = "uc_language_name", columnNames = "name")
})
@Cacheable(cacheNames = "languages")
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Language language)) {
            return false;
        }
        return Objects.equals(name, language.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}