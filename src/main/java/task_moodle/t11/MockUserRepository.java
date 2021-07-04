package task_moodle.t11;

public class MockUserRepository extends UserRepository {
    private boolean isMockTriggered = false;

    @Override
    public void save(User user) {
        super.save(user);
        isMockTriggered = true;
        System.out.println(user + " - сохранен в MockUserRepository");
    }
}
