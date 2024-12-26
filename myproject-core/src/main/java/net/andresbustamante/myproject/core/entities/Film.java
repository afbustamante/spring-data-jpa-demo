package net.andresbustamante.myproject.core.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "film")
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
    private List<FilmActor> filmActors;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "film")
    private List<FilmCategory> filmCategories;

    public Film() {
        filmActors = new ArrayList<>();
        filmCategories = new ArrayList<>();
    }
}