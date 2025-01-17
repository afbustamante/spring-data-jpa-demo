package net.andresbustamante.myproject.web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = DemoApplication.class)
@ActiveProfiles({"test", "h2"})
class DemoApplicationIT {

    @Test
    void contextLoads() {
        assertTrue(true); // NOSONAR
    }
}
