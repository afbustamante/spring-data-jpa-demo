package net.andresbustamante.myproject.api.util;

import lombok.Getter;

@Getter
public class UserContext {

    private final String username;

    public UserContext(final String username) {
        this.username = username;
    }
}
