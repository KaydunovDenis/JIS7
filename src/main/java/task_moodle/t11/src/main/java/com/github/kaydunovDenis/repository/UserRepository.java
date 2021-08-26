package com.github.kaydunovDenis.repository;

import com.github.kaydunovDenis.model.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Data
public class UserRepository {
    private Map<Long, User> USERS = new HashMap<>();

    public User save(User user) {
        USERS.put(user.getId(), user);
        log.info("{} save in {}.",user, this.getClass().getSimpleName());
        return user;
    }
}
