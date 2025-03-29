package net.andresbustamante.myproject.api.util;

import java.util.Locale;

import lombok.Getter;

@Getter
public class UserContext {

    private final String username;
    private final Locale locale;

    public UserContext(final String username) {
        this.username = username;
        this.locale = Locale.getDefault();
    }

    public UserContext(final String username, final Locale locale) {
        this.username = username;
        this.locale = locale;
    }
}
