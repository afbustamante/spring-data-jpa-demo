package net.andresbustamante.myproject.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.myproject.core.entities.Staff;

public interface StaffDao extends JpaRepository<Staff, Short> {

    List<Staff> findAllByActiveTrue();
}
