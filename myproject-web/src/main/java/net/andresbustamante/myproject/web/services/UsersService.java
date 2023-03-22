package net.andresbustamante.myproject.web.services;

import net.andresbustamante.myproject.api.services.UserManagementService;
import net.andresbustamante.myproject.api.services.UserSearchService;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UserSearchService userSearchService;
    private final UserManagementService userManagementService;

    public UsersService(UserSearchService userSearchService, UserManagementService userManagementService) {
        this.userSearchService = userSearchService;
        this.userManagementService = userManagementService;
    }
}
