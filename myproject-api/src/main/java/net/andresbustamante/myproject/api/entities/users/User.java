package net.andresbustamante.myproject.api.entities.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.andresbustamante.myproject.api.entities.AbstractEntity;
import net.andresbustamante.myproject.api.enums.GenderEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "T_USER")
@Getter @Setter @NoArgsConstructor
public class User extends AbstractEntity {

    @Id
    @SequenceGenerator(name = "s_user", sequenceName = "s_user", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_user")
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String surname;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "T_USER_ROLE", inverseJoinColumns = @JoinColumn(name = "ROLE_ID"), joinColumns = @JoinColumn(name = "USER_ID"))
    private Set<Role> roles;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @NotNull
    private String email;

    private boolean active;

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
