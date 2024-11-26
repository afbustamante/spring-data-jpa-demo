package net.andresbustamante.myproject.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.myproject.core.entities.Store;

public interface StoreDao extends JpaRepository<Store, Short> {
}
