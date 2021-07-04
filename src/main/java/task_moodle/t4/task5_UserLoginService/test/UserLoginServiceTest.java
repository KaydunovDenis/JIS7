package task_moodle.t4.task5_UserLoginService.test;

import task_moodle.t4.task5_UserLoginService.src.User;
import task_moodle.t4.task5_UserLoginService.src.UserLoginService;

public class UserLoginServiceTest {
    public static void main(String[] args) {
        UserLoginService service = new UserLoginService();
        User userOne = new User("user-login", "user-password");
        System.out.println(service.login(userOne, "user-password-12345")); //Should return false
        User userTwo = new User("user-Two", "123");
        System.out.println(service.login(userTwo, "123")); //Should return false

    }
}
