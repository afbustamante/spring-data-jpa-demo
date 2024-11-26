package net.andresbustamante.myproject.core.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.myproject.api.model.StaffCreationDto;
import net.andresbustamante.myproject.api.services.AddressManagementService;
import net.andresbustamante.myproject.api.services.StaffManagementService;
import net.andresbustamante.myproject.core.dao.AddressDao;
import net.andresbustamante.myproject.core.dao.StaffDao;
import net.andresbustamante.myproject.core.dao.StoreDao;
import net.andresbustamante.myproject.core.entities.Address;
import net.andresbustamante.myproject.core.entities.Staff;
import net.andresbustamante.myproject.core.entities.Store;

@Service
public class StaffManagementServiceImpl implements StaffManagementService {

    private final StaffDao staffDao;
    private final AddressManagementService addressManagementService;
    private final AddressDao addressDao;
    private final StoreDao storeDao;

    public StaffManagementServiceImpl(StaffDao staffDao, AddressManagementService addressManagementService,
            AddressDao addressDao, StoreDao storeDao) {
        this.staffDao = staffDao;
        this.addressManagementService = addressManagementService;
        this.addressDao = addressDao;
        this.storeDao = storeDao;
    }

    @Override
    @Transactional
    public short createStaff(final StaffCreationDto staff) {
        Staff newStaff = new Staff();
        newStaff.setFirstName(staff.firstName());
        newStaff.setLastName(staff.lastName());
        newStaff.setEmail(staff.email());
        newStaff.setUsername(staff.username());
        newStaff.setPassword(staff.password());

        Store store = storeDao.getReferenceById(staff.storeId());

        short addressId = addressManagementService.createAddress(staff.address());

        Address newAddress = addressDao.getReferenceById(addressId);

        newStaff.setAddress(newAddress);
        newStaff.setStore(store);

        newStaff = staffDao.save(newStaff);

        return newStaff.getId();
    }
}
