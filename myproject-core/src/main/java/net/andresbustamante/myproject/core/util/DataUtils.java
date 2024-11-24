package net.andresbustamante.myproject.core.util;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.andresbustamante.myproject.core.dao.AddressDao;
import net.andresbustamante.myproject.core.dao.CityDao;
import net.andresbustamante.myproject.core.dao.CountryDao;
import net.andresbustamante.myproject.core.dao.StaffDao;
import net.andresbustamante.myproject.core.entities.Address;
import net.andresbustamante.myproject.core.entities.City;
import net.andresbustamante.myproject.core.entities.Country;
import net.andresbustamante.myproject.core.entities.Staff;

@Component
@Profile("h2")
public class DataUtils {

    private final CountryDao countryDao;
    private final CityDao cityDao;
    private final AddressDao addressDao;
    private final StaffDao staffDao;

    public DataUtils(CountryDao countryDao, CityDao cityDao, AddressDao addressDao, StaffDao staffDao) {
        this.countryDao = countryDao;
        this.cityDao = cityDao;
        this.addressDao = addressDao;
        this.staffDao = staffDao;
    }

    @Scheduled(fixedDelay = 1_800_000_000L)
    public void loadData() {
        Country country = new Country("France");
        country = countryDao.save(country);

        City city = new City("Lyon", country);
        city = cityDao.save(city);

        Address address = new Address("123 Rue de la Joie", null, "1er arrondissement", city, "69001", "+33 6 20 30 40 50");
        address = addressDao.save(address);

        Staff staff = new Staff("Andres", "Bustamante", "andresbustamante@email.com", "andresbustamante", "password", address);
        staff = staffDao.save(staff);
    }
}
