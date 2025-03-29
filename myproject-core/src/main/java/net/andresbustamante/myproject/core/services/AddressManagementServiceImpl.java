package net.andresbustamante.myproject.core.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.andresbustamante.myproject.api.model.AddressCreationDto;
import net.andresbustamante.myproject.api.services.AddressManagementService;
import net.andresbustamante.myproject.api.util.UserContext;
import net.andresbustamante.myproject.core.dao.AddressDao;
import net.andresbustamante.myproject.core.dao.CityDao;
import net.andresbustamante.myproject.core.entities.Address;
import net.andresbustamante.myproject.core.entities.City;

@Service
@Slf4j
public class AddressManagementServiceImpl implements AddressManagementService {

    private final AddressDao addressDao;
    private final CityDao cityDao;

    public AddressManagementServiceImpl(AddressDao addressDao, CityDao cityDao) {
        this.addressDao = addressDao;
        this.cityDao = cityDao;
    }

    @Override
    @Transactional
    public short createAddress(final AddressCreationDto address, final UserContext ctx) {
        Address newAddress = new Address();
        newAddress.setLine1(address.line1());
        newAddress.setLine2(address.line2());
        newAddress.setPostalCode(address.postalCode());
        newAddress.setDistrict(address.district());
        newAddress.setPhoneNumber(address.phoneNumber());

        City city = cityDao.getReferenceById(address.cityId());
        newAddress.setCity(city);

        newAddress = addressDao.save(newAddress);

        log.info("New address created in {} by {} with the ID {}", city.getName(), ctx.getUsername(), newAddress.getId());

        return newAddress.getId();
    }
}
