package net.andresbustamante.myproject.core.entities;

import java.util.Objects;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "city", uniqueConstraints = {
        @UniqueConstraint(name = "uc_city_country", columnNames = {"country_id", "city"})
})
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "cities")
@Immutable
@Getter
@Setter
public class City extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Short id;

    @Column(name = "city")
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof City city)) {
            return false;
        }
        return Objects.equals(id, city.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
