package net.andresbustamante.myproject.core.entities;

import java.io.Serializable;
import java.time.Instant;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "store")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Store implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id", nullable = false)
    private Short id;

    @OneToMany(mappedBy = "store")
    private Set<Staff> staff;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_staff_id")
    private Staff manager;

    @CreatedDate
    @LastModifiedDate
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;
}
