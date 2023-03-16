package net.andresbustamante.myproject.core.services;

import net.andresbustamante.myproject.api.entities.users.User;
import net.andresbustamante.myproject.core.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserSearchServiceTest {

    @InjectMocks
    private UserSearchServiceImpl userSearchService;

    @Mock
    private UserRepository userRepository;

    @Test
    void testLoadExistingUser() {
        // Given
        User user = new User(1L);
        user.setEmail("test@email.com");

        when(userRepository.getById(1L)).thenReturn(user);

        // When
        var result = userSearchService.loadUser(1L);

        // Then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("test@email.com", result.getEmail());
    }

    @Test
    void testLoadUnknownUser() {
        // Given
        User user = new User(1L);
        user.setEmail("test@email.com");

        when(userRepository.getById(1L)).thenThrow(EntityNotFoundException.class);

        // When - Then
        assertThrows(EntityNotFoundException.class, () -> userSearchService.loadUser(1L));
    }
}