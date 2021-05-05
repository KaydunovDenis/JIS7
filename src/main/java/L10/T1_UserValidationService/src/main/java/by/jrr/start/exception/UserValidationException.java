package by.jrr.start.exception;

public class UserValidationException extends RuntimeException {
    final String message;

    public UserValidationException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UserValidationException: " + message;
    }
}
