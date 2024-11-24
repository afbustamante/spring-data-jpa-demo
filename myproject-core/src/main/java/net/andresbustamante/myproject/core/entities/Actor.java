package net.andresbustamante.myproject.core.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "actor")
@Getter
@Setter
public class Actor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id", nullable = false)
    private Short id;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;
}
