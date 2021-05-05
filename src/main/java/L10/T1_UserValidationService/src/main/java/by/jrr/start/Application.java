package by.jrr.start;

import by.jrr.start.model.User;
import by.jrr.start.service.UserValidationService;

public class Application {

    public static void main(String[] args) {
        UserValidationService userValidationService = new UserValidationService();
        User user = new User("Denis", "Kaydunov", 31);
        userValidationService.validate(user);

        User userErrorMin = new User("De", "Kaydunov", 31);
        userValidationService.validate(userErrorMin);

        User userErrorMax = new User("Denis", "Kaydunov la Belarus from Gomel san Victor", 31);
        userValidationService.validate(userErrorMax);

        User userErrorAge = new User("Denis", "Kaydunov", 121);
        userValidationService.validate(userErrorAge);
    }
}
