package net.andresbustamante.myproject.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import net.andresbustamante.myproject.core.mappers.DateMapperImpl;
import net.andresbustamante.myproject.core.mappers.FilmMapperImpl;
import net.andresbustamante.myproject.core.services.ActorManagementServiceImpl;
import net.andresbustamante.myproject.core.services.FilmManagementServiceImpl;

@Configuration
@Import({
        FilmManagementServiceImpl.class,
        ActorManagementServiceImpl.class,
        FilmMapperImpl.class,
        DateMapperImpl.class
})
public class FilmManagementServiceTestConfig {
}
