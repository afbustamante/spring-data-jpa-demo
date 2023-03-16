package net.andresbustamante.myproject.core.services;

import net.andresbustamante.myproject.api.entities.users.User;
import net.andresbustamante.myproject.core.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserManagementServiceTest {

    @InjectMocks
    private UserManagementServiceImpl userManagementService;

    @Mock
    private UserRepository userRepository;

    @Test
    void createUser() {
        // Given
        User user = new User();
        user.setEmail("test@email.com");
        user.setFirstName("Test");
        user.setSurname("User");

        when(userRepository.save(any(User.class))).thenReturn(new User(1L));

        // When
        var result = userManagementService.createUser(user);

        // Then
        assertEquals(1L, result);

        verify(userRepository).save(any(User.class));
    }

    @Test
    void deleteUser() {
        // Given
        User user = new User(1L);

        // When - Then
        assertDoesNotThrow(() -> userManagementService.deleteUser(user));

        verify(userRepository).deleteById(anyLong());
    }
}