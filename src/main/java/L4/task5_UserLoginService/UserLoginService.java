package L4.task5_UserLoginService;

public class UserLoginService {

    boolean login(User user, String password) {
        if (!user.isItBlocked() && user.getPassword().equals(password)) {
            user.resetAttempts();
            return true;
        }
        if (--(user.attemptsBeforeBlocking) == 0) {
            user.blockUser();
        }
        return false;
    }
}
