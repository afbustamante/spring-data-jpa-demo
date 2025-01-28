package net.andresbustamante.myproject.core.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.andresbustamante.myproject.api.model.AddressCreationDto;
import net.andresbustamante.myproject.api.services.AddressManagementService;
import net.andresbustamante.myproject.core.dao.AddressDao;
import net.andresbustamante.myproject.core.dao.CityDao;
import net.andresbustamante.myproject.core.entities.Address;
import net.andresbustamante.myproject.core.entities.City;

@Service
public class AddressManagementServiceImpl implements AddressManagementService {

    private final AddressDao addressDao;
    private final CityDao cityDao;

    public AddressManagementServiceImpl(AddressDao addressDao, CityDao cityDao) {
        this.addressDao = addressDao;
        this.cityDao = cityDao;
    }

    @Override
    @Transactional
    public short createAddress(final AddressCreationDto address) {
        Address newAddress = new Address();
        newAddress.setLine1(address.line1());
        newAddress.setLine2(address.line2());
        newAddress.setPostalCode(address.postalCode());
        newAddress.setDistrict(address.district());
        newAddress.setPhoneNumber(address.phoneNumber());

        City city = cityDao.getReferenceById(address.cityId());
        newAddress.setCity(city);

        newAddress = addressDao.save(newAddress);

        return newAddress.getId();
    }
}
