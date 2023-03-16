package net.andresbustamante.myproject.core.services;

import net.andresbustamante.myproject.api.entities.users.User;
import net.andresbustamante.myproject.api.enums.GenderEnum;
import net.andresbustamante.myproject.api.services.UserSearchService;
import net.andresbustamante.myproject.core.config.CoreTestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = CoreTestConfig.class)
@ExtendWith(SpringExtension.class)
class UserSearchServiceIT {

    @Autowired
    private UserSearchService userSearchService;

    @Test
    @Transactional
    void loadUser() {
        // Given
        long userId = 1L;

        // When
        User user = userSearchService.loadUser(userId);

        // Then
        assertNotNull(user);
        assertTrue(user.isActive());
        assertEquals(GenderEnum.OTHER, user.getGender());
        assertEquals("Admin", user.getSurname());
        assertTrue(user.getCreationDate().isBefore(Instant.now()));
        assertNotNull(user.getRoles());
        assertTrue(user.getRoles().stream().anyMatch(r -> r.getName().equals("Admin")));
    }
}