import model.User;
import service.UserValidationService;

public class UserValidationServiceDemo {

    public static void main(String[] args) {
        UserValidationService userValidationService = new UserValidationService();
        User user = new User("Denis", "Kaydunov", 31);
        userValidationService.validateAll(user);

        User userErrorMin = new User("De", "Kaydunov", 31);
        userValidationService.validateAll(userErrorMin);

        User userErrorMax = new User("Denis", "Kaydunov la Belarus from Gomel san Victor", 31);
        userValidationService.validateAll(userErrorMax);

        User userErrorAge = new User("Denis", "Kaydunov", 121);
        userValidationService.validateAll(userErrorAge);
    }
}
