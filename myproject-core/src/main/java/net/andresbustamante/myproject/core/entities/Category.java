package net.andresbustamante.myproject.core.entities;

import java.util.Objects;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "category", uniqueConstraints = {
        @UniqueConstraint(name = "uc_category_name", columnNames = "name")
})
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "categories")
@Immutable
@Getter
@Setter
public class Category extends AuditableEntity {

    @Id
    @Column(name = "category_id", nullable = false)
    private Byte id;

    @Size(max = 25)
    @NotNull
    private String name;

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
