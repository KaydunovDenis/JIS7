package L11;

public class MockUserRepository extends UserRepository {
    private boolean isMockTriggered = false;


    public boolean isMockTriggered() {
        if (this instanceof MockUserRepository) {
            return true;
        } else return false;
    }

    @Override
    public void save(User user) {
        super.save(user);
        isMockTriggered = true;
        System.out.println(user + " - сохранен в MockUserRepository");
    }
}
