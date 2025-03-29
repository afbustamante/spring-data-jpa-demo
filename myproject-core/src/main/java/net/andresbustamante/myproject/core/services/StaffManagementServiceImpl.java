package net.andresbustamante.myproject.core.services;

import java.util.Set;

import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.andresbustamante.myproject.api.exceptions.ApplicationException;
import net.andresbustamante.myproject.api.exceptions.InvalidUsernameException;
import net.andresbustamante.myproject.api.model.StaffCreationDto;
import net.andresbustamante.myproject.api.services.AddressManagementService;
import net.andresbustamante.myproject.api.services.StaffManagementService;
import net.andresbustamante.myproject.api.util.UserContext;
import net.andresbustamante.myproject.core.dao.AddressDao;
import net.andresbustamante.myproject.core.dao.StaffDao;
import net.andresbustamante.myproject.core.dao.StoreDao;
import net.andresbustamante.myproject.core.entities.Address;
import net.andresbustamante.myproject.core.entities.Staff;
import net.andresbustamante.myproject.core.entities.Store;

@Service
@Slf4j
public class StaffManagementServiceImpl implements StaffManagementService {

    private static final Set<String> FORBIDDEN_USERNAMES = Set.of("sys", "system", "admin", "administrator", "root",
            "user", "anonymous", "yes", "no", "true", "false");

    private final StaffDao staffDao;
    private final AddressManagementService addressManagementService;
    private final AddressDao addressDao;
    private final StoreDao storeDao;
    private final PasswordEncoder passwordEncoder;
    private final MessageSource messageSource;

    public StaffManagementServiceImpl(StaffDao staffDao, AddressManagementService addressManagementService,
            AddressDao addressDao, StoreDao storeDao, PasswordEncoder passwordEncoder, MessageSource messageSource) {
        this.staffDao = staffDao;
        this.addressManagementService = addressManagementService;
        this.addressDao = addressDao;
        this.storeDao = storeDao;
        this.passwordEncoder = passwordEncoder;
        this.messageSource = messageSource;
    }

    @Override
    @Transactional
    public short createStaff(final StaffCreationDto staff, final UserContext ctx) throws ApplicationException {
        if (FORBIDDEN_USERNAMES.stream().anyMatch(
                forbiddenUsername -> forbiddenUsername.equalsIgnoreCase(staff.username()))) {
            throw new InvalidUsernameException(messageSource.getMessage(
                    "staff.creation.error.username.forbidden", new Object[]{staff.username()}, ctx.getLocale()));
        }

        Staff newStaff = new Staff();
        newStaff.setFirstName(staff.firstName());
        newStaff.setLastName(staff.lastName());
        newStaff.setEmail(staff.email());
        newStaff.setUsername(staff.username());
        newStaff.setPassword(passwordEncoder.encode(staff.password()));

        Store store = storeDao.getReferenceById(staff.storeId());

        short addressId = addressManagementService.createAddress(staff.address(), ctx);

        Address newAddress = addressDao.getReferenceById(addressId);

        newStaff.setAddress(newAddress);
        newStaff.setStore(store);

        newStaff = staffDao.save(newStaff);

        log.info("New staff member {} created by {} with the ID {}", newStaff.getUsername(), ctx.getUsername(),
                newStaff.getId());

        return newStaff.getId();
    }
}
