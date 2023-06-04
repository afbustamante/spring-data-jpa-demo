package net.andresbustamante.myproject.batch.config;

import org.springframework.stereotype.Component;

import net.andresbustamante.myproject.core.util.UserContext;

@Component
public class BatchUserContext implements UserContext {

    @Override
    public String getUsername() {
        return "BATCH";
    }
}
