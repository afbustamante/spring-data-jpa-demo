package net.andresbustamante.myproject.core.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "film", uniqueConstraints = {
        @UniqueConstraint(name = "uc_film_title_year", columnNames = {"title", "release_year", "length"})
})
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Integer id;

    @Size(max = 128)
    @NotNull
    private String title;

    @Lob
    private String description;

    @Column(name = "release_year")
    private Short releaseYear;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;

    @NotNull
    @Column(name = "rental_duration")
    private Short rentalDuration;

    @NotNull
    @Column(name = "rental_rate", precision = 4, scale = 2)
    private BigDecimal rentalRate;

    private Short length;

    @NotNull
    @Column(name = "replacement_cost", precision = 5, scale = 2)
    private BigDecimal replacementCost;

    @Pattern(regexp = "^(G|PG|PG-13|R|NC-17)$", message = "Invalid rating")
    private String rating;

    @Lob
    @Column(name = "special_features")
    private String specialFeatures;

    @CreatedDate
    @LastModifiedDate
    @NotNull
    @Column(name = "last_update")
    private Instant lastUpdate;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "film")
    private Set<FilmActor> filmActors;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "film")
    private Set<FilmCategory> filmCategories;

    public Film() {
        filmActors = new LinkedHashSet<>();
        filmCategories = new LinkedHashSet<>();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Film film = (Film) o;
        return Objects.equals(title, film.title) && Objects.equals(releaseYear, film.releaseYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseYear);
    }
}