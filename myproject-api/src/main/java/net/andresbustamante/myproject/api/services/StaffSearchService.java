package net.andresbustamante.myproject.api.services;

import java.util.Collection;

import net.andresbustamante.myproject.api.model.StaffDto;

public interface StaffSearchService {

    Collection<StaffDto> fetchActiveStaff();
}
