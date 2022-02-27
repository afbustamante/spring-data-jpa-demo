package net.andresbustamante.myproject.api.services;

import net.andresbustamante.myproject.api.entities.users.Role;

import java.util.List;

public interface RoleSearchService {

    List<Role> findRoles();
}
