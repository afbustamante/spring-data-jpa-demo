package net.andresbustamante.myproject.api.exceptions;

public class InvalidUsernameException extends FunctionalException {

    public InvalidUsernameException(final String message) {
        super(message);
    }

    public InvalidUsernameException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
