package net.andresbustamante.myproject.core.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import net.andresbustamante.myproject.core.config.CoreDaoTestConfig;

@DataJpaTest
@ContextConfiguration(classes = CoreDaoTestConfig.class)
class StaffDaoIT {

    @Autowired
    private StaffDao staffDao;

    @Test
    void testFindAllByActiveTrue() {
        var staff = staffDao.findAllActiveStaff();

        assertNotNull(staff);
    }
}