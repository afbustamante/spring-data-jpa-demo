package net.andresbustamante.myproject.api.services;

import net.andresbustamante.myproject.api.model.AddressCreationDto;

public interface AddressManagementService {

    short createAddress(AddressCreationDto address);
}
