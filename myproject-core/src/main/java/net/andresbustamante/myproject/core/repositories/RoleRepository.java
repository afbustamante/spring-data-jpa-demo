package net.andresbustamante.myproject.core.repositories;

import net.andresbustamante.myproject.api.entities.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Short> {
}
