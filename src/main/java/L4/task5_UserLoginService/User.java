package L4.task5_UserLoginService;

public class User {
    String login;
    private String password;
    private boolean isItBlocked = false;
    public int attemptsBeforeBlocking = 3;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isItBlocked=" + isItBlocked +
                ", attemptsBeforeBlocking=" + attemptsBeforeBlocking +
                '}';
    }

    public boolean isItBlocked() {
        return isItBlocked;
    }

    public Object getPassword() {
        return password;
    }

    public void resetAttempts() {
        attemptsBeforeBlocking = 3;
    }

    public void blockUser() {
        isItBlocked = true;
    }
}
