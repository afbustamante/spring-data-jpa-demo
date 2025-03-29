package net.andresbustamante.myproject.api.exceptions;

public class FunctionalException extends ApplicationException {

    protected FunctionalException(final String message) {
        super(message);
    }

    protected FunctionalException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
