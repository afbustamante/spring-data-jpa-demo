package net.andresbustamante.myproject.core.config;

import net.andresbustamante.myproject.core.util.UserContext;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@EnableAutoConfiguration
@EntityScan(basePackages = "net.andresbustamante.myproject.api.entities")
@ComponentScan(basePackages = "net.andresbustamante.myproject.core")
public class CoreTestConfig {

    @Bean
    public UserContext userContext() {
        return () -> "test";
    }
}
