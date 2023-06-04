package net.andresbustamante.myproject.web.controllers;

import net.andresbustamante.myproject.web.dto.Role;
import net.andresbustamante.myproject.web.services.RolesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/roles")
public class RolesController extends AbstractController {

    private final RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Role>> findRoles() {
        List<Role> roles = rolesService.findRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Role> loadRole(@PathVariable Short id) {
        Role role = rolesService.findRole(id);

        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
