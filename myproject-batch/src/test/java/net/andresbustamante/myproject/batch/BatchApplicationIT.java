package net.andresbustamante.myproject.batch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = BatchApplication.class)
@ActiveProfiles({"test", "h2"})
class BatchApplicationIT {

    @Test
    void contextLoads() {
        assertTrue(true); // NOSONAR
    }
}
