package net.andresbustamante.myproject.core.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "staff")
@Getter
@Setter
public class Staff extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id", nullable = false)
    private Short id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    public Staff() {
        lastUpdate = Instant.now();
        active = true;
    }

    public Staff(final String firstName, final String lastName, final String email, final String username,
            final String password, final Address address) {
        this();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.email = email;
        this.username = username;
        this.password = password;
        this.address = address;
    }
}
