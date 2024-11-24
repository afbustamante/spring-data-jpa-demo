package net.andresbustamante.myproject.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.myproject.core.entities.Address;

public interface AddressDao extends JpaRepository<Address, Short> {
}
