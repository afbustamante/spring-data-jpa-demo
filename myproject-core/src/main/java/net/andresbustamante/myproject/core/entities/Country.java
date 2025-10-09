package net.andresbustamante.myproject.core.entities;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "country", uniqueConstraints = {
        @UniqueConstraint(name = "uc_country_name", columnNames = "country")
})
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "countries")
@Immutable
@Getter
@Setter
public class Country extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private Short id;

    @NotNull
    @Column(name = "country")
    private String name;

    @OneToMany(mappedBy = "country")
    private Set<City> cities;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Country country = (Country) o;
        return Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
