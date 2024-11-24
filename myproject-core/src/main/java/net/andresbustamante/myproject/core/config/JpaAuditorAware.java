package net.andresbustamante.myproject.core.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import net.andresbustamante.myproject.api.util.UserContext;

public class JpaAuditorAware implements AuditorAware<String> {

    @Autowired
    private UserContext context;

    @Override
    public Optional<String> getCurrentAuditor() {
        return (context.getUsername() != null) ? Optional.of(context.getUsername()) : Optional.empty();
    }
}
