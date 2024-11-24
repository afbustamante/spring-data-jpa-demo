package net.andresbustamante.myproject.core.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@EnableAutoConfiguration
@Import({
        JpaConfig.class,
        TestUserContext.class
})
@EntityScan(basePackages = "net.andresbustamante.myproject.core.entities")
public class CoreDaoTestConfig {
}
