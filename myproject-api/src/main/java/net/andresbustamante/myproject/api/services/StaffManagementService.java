package net.andresbustamante.myproject.api.services;

import net.andresbustamante.myproject.api.model.StaffCreationDto;

public interface StaffManagementService {

    short createStaff(StaffCreationDto address);
}
