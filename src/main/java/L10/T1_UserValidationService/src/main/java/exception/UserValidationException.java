package exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UserValidationException extends RuntimeException {
    private static final Logger logger = Logger.getGlobal();
    private final String message;

    public UserValidationException(String message) {
        this.message = message;
        logger.log(Level.WARNING,message);
    }

    @Override
    public String toString() {
        return "UserValidationException: " + message;
    }
}
