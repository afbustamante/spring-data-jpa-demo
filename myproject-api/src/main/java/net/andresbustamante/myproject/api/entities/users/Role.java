package net.andresbustamante.myproject.api.entities.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.andresbustamante.myproject.api.entities.AbstractEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Immutable;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "t_roles")
@Immutable
@Getter @Setter @NoArgsConstructor
public class Role extends AbstractEntity implements Serializable {

    @Id
    private Short id;

    @NotNull
    private String name;

    private boolean active;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id.equals(role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
