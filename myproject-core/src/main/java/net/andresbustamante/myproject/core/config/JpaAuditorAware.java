package net.andresbustamante.myproject.core.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class JpaAuditorAware implements AuditorAware<String> {

    public static final String ANONYMOUS_USER = "anonymous";

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication instanceof AnonymousAuthenticationToken ? Optional.of(ANONYMOUS_USER) : Optional.of(authentication.getName());
    }
}
