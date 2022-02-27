package net.andresbustamante.myproject.core.services;

import net.andresbustamante.myproject.api.entities.users.User;
import net.andresbustamante.myproject.api.enums.GenderEnum;
import net.andresbustamante.myproject.api.services.UserManagementService;
import net.andresbustamante.myproject.api.services.UserSearchService;
import net.andresbustamante.myproject.core.config.CoreTestConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = CoreTestConfig.class)
@ExtendWith(SpringExtension.class)
class UserManagementServiceIntegrationTest {

    @Autowired
    private UserManagementService userManagementService;

    @Autowired
    private UserSearchService userSearchService;

    @Test
    @Transactional
    void createUser() {
        // Given
        User user = new User();
        user.setEmail("john.doe@email.com");
        user.setFirstName("John");
        user.setSurname("Doe");
        user.setGender(GenderEnum.MALE);

        // When
        long id = userManagementService.createUser(user);

        // Then
        assertTrue(id > 0L);

        User dbUser = userSearchService.loadUser(id);
        assertNotNull(dbUser);
        assertNotNull(dbUser.getId());
        assertNotNull(dbUser.getCreationDate());
        assertNotNull(dbUser.getCreator());
        assertEquals("test", dbUser.getCreator());
        assertNull(dbUser.getModificationDate());
        assertNull(dbUser.getModifier());
        assertNotNull(dbUser.getVersion());
        assertEquals(0, dbUser.getVersion());
    }
}