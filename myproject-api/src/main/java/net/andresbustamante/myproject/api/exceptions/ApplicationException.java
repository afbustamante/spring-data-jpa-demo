package net.andresbustamante.myproject.api.exceptions;

public class ApplicationException extends Exception {

    protected ApplicationException(final String message) {
        super(message);
    }

    protected ApplicationException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
