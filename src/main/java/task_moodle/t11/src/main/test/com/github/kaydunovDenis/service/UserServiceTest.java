package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.model.User;
import com.github.kaydunovDenis.repository.MockUserRepository;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void addUser() {
        MockUserRepository users = new MockUserRepository();
        UserService service = new UserService(users);
        User user = new User(1L, "Antonio", 30);

        int expectedSize = 0;
        int actualSize = users.getUSERS().size();
        assertEquals(expectedSize, actualSize);
        assertFalse(users.isMockTriggered());

        service.addUser(user);
        expectedSize = 1;
        actualSize = users.getUSERS().size();
        assertEquals(expectedSize, actualSize);
        assertTrue(users.isMockTriggered());
    }
}