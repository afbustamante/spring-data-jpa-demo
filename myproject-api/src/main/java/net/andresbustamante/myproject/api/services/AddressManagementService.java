package net.andresbustamante.myproject.api.services;

import net.andresbustamante.myproject.api.model.AddressCreationDto;
import net.andresbustamante.myproject.api.util.UserContext;

public interface AddressManagementService {

    short createAddress(AddressCreationDto address, UserContext ctx);
}
