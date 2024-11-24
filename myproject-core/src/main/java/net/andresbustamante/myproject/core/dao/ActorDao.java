package net.andresbustamante.myproject.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.andresbustamante.myproject.core.entities.Actor;

public interface ActorDao extends JpaRepository<Actor, Integer> {
}
