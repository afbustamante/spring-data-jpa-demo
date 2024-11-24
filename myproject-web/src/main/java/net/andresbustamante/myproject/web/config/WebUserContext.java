package net.andresbustamante.myproject.web.config;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import net.andresbustamante.myproject.api.util.UserContext;

@Component
public class WebUserContext implements UserContext {

    @Override
    public String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (authentication instanceof AnonymousAuthenticationToken) ? "anonymous" : authentication.getName();
    }
}
