package net.andresbustamante.myproject.web.services;

import net.andresbustamante.myproject.api.services.RoleSearchService;
import net.andresbustamante.myproject.web.dto.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesService {

    private final RoleSearchService roleSearchService;

    public RolesService(RoleSearchService roleSearchService) {
        this.roleSearchService = roleSearchService;
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<Role> findRoles() {
        var roles = roleSearchService.findRoles();

        List<Role> result = new ArrayList<>();

        roles.forEach(role -> {
            Role dto = mapRole(role);
            result.add(dto);
        });

        return result;
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public Role findRole(Short id) {
        var role = roleSearchService.loadRole(id);

        return (role != null) ? mapRole(role) : null;
    }

    private Role mapRole(net.andresbustamante.myproject.api.entities.users.Role role) {
        Role dto = new Role();
        dto.setId(role.getId());
        dto.setName(role.getName());
        return dto;
    }
}
