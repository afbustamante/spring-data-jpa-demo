package net.andresbustamante.myproject.api.services;

import net.andresbustamante.myproject.api.entities.users.User;

public interface UserManagementService {

    long createUser(User user);

    void updateUser(User user);

    void deleteUser(User user);
}
