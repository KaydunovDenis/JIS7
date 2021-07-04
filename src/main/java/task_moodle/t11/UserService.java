package task_moodle.t11;

public class UserService {

    public void addUser(UserRepository repository, User user) {
        if (repository.getRepository().containsKey(user.getId())) {
            repository.save(user);
        } else System.out.println(user.getId() + " - данный id занят");
    }
}
