package net.andresbustamante.myproject.core.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.andresbustamante.myproject.core.entities.Staff;
import net.andresbustamante.myproject.core.projections.StaffProjection;

public interface StaffDao extends JpaRepository<Staff, Short> {

    @Query("""
            SELECT s.id AS id, s.username AS username, s.email AS email,
                s.active AS active, s.firstName as firstName, s.lastName AS lastName,
                c.name AS city, k.name AS country,
                a.line1 AS addressLine1, a.line2 AS addressLine2, a.postalCode AS postalCode,
                a.phone AS phone
            FROM Staff s
            INNER JOIN s.address a
            INNER JOIN a.city c
            INNER JOIN c.country k
            WHERE s.active IS true
            """)
    List<StaffProjection> findAllActives();

    @Query("""
            FROM Staff s
            INNER JOIN FETCH s.address a
            INNER JOIN FETCH a.city c
            INNER JOIN FETCH c.country k
            WHERE s.active IS true
            """)
    List<Staff> findAllActiveStaff();

    List<Staff> findAllByActiveTrue();

    Optional<Staff> findByUsername(String username);
}
