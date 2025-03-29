package net.andresbustamante.myproject.core.entities;

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

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.annotation.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "city", uniqueConstraints = {
        @UniqueConstraint(name = "uc_city_country", columnNames = {"country_id", "city"})
})
@Cacheable(cacheNames = "cities")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
}
