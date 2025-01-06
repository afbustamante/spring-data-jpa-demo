package net.andresbustamante.myproject.core.entities;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "staff", uniqueConstraints = {
        @UniqueConstraint(name = "uc_staff_email", columnNames = "email"),
        @UniqueConstraint(name = "uc_staff_username", columnNames = "username")
})
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Staff extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id", nullable = false)
    private Short id;

    @Size(max = 50)
    @NotNull
    private String email;

    @NotNull
    private boolean active;

    @Size(max = 16)
    @NotNull
    private String username;

    @Size(max = 64)
    @NotNull
    private String password;

    private byte[] picture;

    @CreatedDate
    @LastModifiedDate
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @OneToMany(mappedBy = "staff")
    private Set<Rental> rentals;

    public Staff() {
        active = true;
        rentals = new LinkedHashSet<>();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Staff staff = (Staff) o;
        return Objects.equals(username, staff.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
