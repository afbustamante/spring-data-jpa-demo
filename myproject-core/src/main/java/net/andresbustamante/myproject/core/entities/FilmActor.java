package net.andresbustamante.myproject.core.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "film_actor")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class FilmActor implements Serializable {

    @EmbeddedId
    private FilmActorId id;

    @CreatedDate
    @LastModifiedDate
    @NotNull
    @Column(name = "last_update")
    private Instant lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id", insertable = false, updatable = false)
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id", insertable = false, updatable = false)
    private Actor actor;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActor filmActor = (FilmActor) o;
        return Objects.equals(id, filmActor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
