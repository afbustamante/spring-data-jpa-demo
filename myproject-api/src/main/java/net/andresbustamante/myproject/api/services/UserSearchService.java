package net.andresbustamante.myproject.api.services;

import net.andresbustamante.myproject.api.entities.users.User;

import java.util.List;

public interface UserSearchService {

    User loadUser(Long id);

    List<User> findUsers();
}
