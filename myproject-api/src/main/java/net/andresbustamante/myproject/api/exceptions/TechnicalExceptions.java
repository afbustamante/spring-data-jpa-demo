package net.andresbustamante.myproject.api.exceptions;

public class TechnicalExceptions extends ApplicationException {

    protected TechnicalExceptions(final String message) {
        super(message);
    }

    protected TechnicalExceptions(final String message, final Throwable cause) {
        super(message, cause);
    }
}
