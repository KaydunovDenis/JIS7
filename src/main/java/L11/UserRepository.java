package L11;

import java.util.HashMap;

/**
 */
public class UserRepository {
    private HashMap<Integer, User> userRepository;

    public void save(User user) {
        userRepository.put(user.getId(), user);
    }

    public HashMap<Integer, User> getRepository() {
        return userRepository;
    }
}
