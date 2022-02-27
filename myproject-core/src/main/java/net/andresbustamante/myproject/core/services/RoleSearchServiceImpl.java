package net.andresbustamante.myproject.core.services;

import net.andresbustamante.myproject.api.entities.users.Role;
import net.andresbustamante.myproject.api.services.RoleSearchService;
import net.andresbustamante.myproject.core.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleSearchServiceImpl implements RoleSearchService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleSearchServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<Role> findRoles() {
        return roleRepository.findAll();
    }
}
