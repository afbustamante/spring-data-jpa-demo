package net.andresbustamante.myproject.api.entities.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.andresbustamante.myproject.api.entities.AbstractEntity;
import net.andresbustamante.myproject.api.enums.GenderEnum;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "t_users")
@Getter @Setter @NoArgsConstructor
public class User extends AbstractEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "s_users", sequenceName = "s_users", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_users")
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String surname;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_user_roles", inverseJoinColumns = @JoinColumn(name = "role_id"), joinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> roles;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @NotNull
    private String email;

    private boolean active;

    public User(final long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
