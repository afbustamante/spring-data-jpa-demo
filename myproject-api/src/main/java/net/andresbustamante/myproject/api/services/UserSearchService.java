package net.andresbustamante.myproject.api.services;

import net.andresbustamante.myproject.api.entities.users.User;

public interface UserSearchService {

    User loadUser(Long id);
}
