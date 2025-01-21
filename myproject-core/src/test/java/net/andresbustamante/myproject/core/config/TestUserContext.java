package net.andresbustamante.myproject.core.config;

import org.springframework.stereotype.Component;

import net.andresbustamante.myproject.api.util.UserContext;

@Component
public class TestUserContext implements UserContext {

    @Override
    public String getUsername() {
        return "test";
    }
}
