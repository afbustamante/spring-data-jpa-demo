package net.andresbustamante.myproject.core.repositories;

import net.andresbustamante.myproject.api.entities.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Short> {

    @Query("from Role where active = true")
    List<Role> findActiveRoles();
}
