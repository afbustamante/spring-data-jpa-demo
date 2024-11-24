package net.andresbustamante.myproject.core.config;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperConfig(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public class MapstructSpringConfig {
}
