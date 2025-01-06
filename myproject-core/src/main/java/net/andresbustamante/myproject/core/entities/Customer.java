package net.andresbustamante.myproject.core.entities;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer", uniqueConstraints = {
        @UniqueConstraint(name = "uc_customer_email", columnNames = "email")
})
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Customer extends Person {

    @Id
    @Column(name = "customer_id", nullable = false)
    private Short id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id")
    private Store store;

    @Size(max = 50)
    private String email;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id")
    private Address address;

    @NotNull
    private boolean active;

    @CreatedDate
    @NotNull
    @Column(name = "create_date")
    private Instant creationDate;

    @LastModifiedDate
    @Column(name = "last_update")
    private Instant lastUpdate;

    @OneToMany(mappedBy = "customer")
    private Set<Rental> rentals;

    @OneToMany(mappedBy = "customer")
    private Set<Payment> payments;

    public Customer() {
        active = true;
        rentals = new LinkedHashSet<>();
        payments = new LinkedHashSet<>();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
