package net.andresbustamante.myproject.api.services;

import net.andresbustamante.myproject.api.exceptions.ApplicationException;
import net.andresbustamante.myproject.api.model.StaffCreationDto;
import net.andresbustamante.myproject.api.util.UserContext;

public interface StaffManagementService {

    short createStaff(StaffCreationDto address, UserContext ctx) throws ApplicationException;
}
