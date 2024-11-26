package net.andresbustamante.myproject.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.myproject.core.entities.City;

public interface CityDao extends JpaRepository<City, Short> {

    List<City> findByCountryId(Short id);
}
