package net.andresbustamante.myproject.web.controllers;

import net.andresbustamante.myproject.api.services.RoleSearchService;
import net.andresbustamante.myproject.web.dto.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/roles")
public class RolesController {

    private final RoleSearchService roleSearchService;

    @Autowired
    public RolesController(RoleSearchService roleSearchService) {
        this.roleSearchService = roleSearchService;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Role>> findRoles() {
        var roles = roleSearchService.findRoles();

        List<Role> result = new ArrayList<>();

        roles.forEach(role -> {
            Role dto = new Role();
            dto.setId(role.getId());
            dto.setName(role.getName());
            result.add(dto);
        });

        return ResponseEntity.ok(result);
    }
}
