package net.andresbustamante.myproject.core.config;

import net.andresbustamante.myproject.core.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class JpaAuditorAware implements AuditorAware<String> {

    @Autowired
    private UserContext context;

    @Override
    public Optional<String> getCurrentAuditor() {
        return (context.getUsername() != null) ? Optional.of(context.getUsername()) : Optional.empty();
    }
}
