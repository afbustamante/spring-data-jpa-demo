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
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "category", uniqueConstraints = {
        @UniqueConstraint(name = "uc_category_name", columnNames = "name")
})
@Cacheable(cacheNames = "categories")
@Getter
@Setter
public class Category implements Serializable {

    @Id
    @Column(name = "category_id", nullable = false)
    private Byte id;

    @Size(max = 25)
    @NotNull
    private String name;

    @CreatedDate
    @LastModifiedDate
    @NotNull
    @Column(name = "last_update")
    private Instant lastUpdate;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}