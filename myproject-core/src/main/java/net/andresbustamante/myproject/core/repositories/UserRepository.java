package net.andresbustamante.myproject.core.repositories;

import net.andresbustamante.myproject.api.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
