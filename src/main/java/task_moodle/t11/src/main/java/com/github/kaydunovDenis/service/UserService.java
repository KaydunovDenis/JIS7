package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.model.User;
import com.github.kaydunovDenis.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserService {
    private UserRepository users;

    public void addUser(User user) {
        if (validateUser(user)) {
            users.save(user);
        }
    }

    private boolean validateUser(User user) {
        return !(user.getId() == null ||
                user.getName() == null ||
                user.getName().equals("") ||
                user.getAge() == null ||
                user.getAge() <= 0);
    }
}
