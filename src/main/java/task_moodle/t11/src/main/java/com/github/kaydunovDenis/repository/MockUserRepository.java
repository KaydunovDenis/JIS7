package com.github.kaydunovDenis.repository;

import com.github.kaydunovDenis.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode(callSuper = true)
@Slf4j
@Data
public class MockUserRepository extends UserRepository {
    private boolean isMockTriggered = false;

    @Override
    public User save(User user) {
        isMockTriggered = true;
        getUSERS().put(user.getId(), user);
        log.info("{} save in {}.",user, this.getClass().getSimpleName());
        return user;
    }
}
