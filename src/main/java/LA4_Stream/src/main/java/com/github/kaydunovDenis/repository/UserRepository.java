package com.github.kaydunovDenis.repository;

import com.github.kaydunovDenis.model.Status;
import com.github.kaydunovDenis.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> userList = new ArrayList<>(){{
        add(new User(0, "ALex", "Alexandro", "AlexAlexandro", 28,
                "alexandro@mail.ru", "12345678", Status.GUEST, false));
        add(new User(1, "Aleksandr", "Full", "Ref1000", 20,
                "alexandro@gmail.com", "qwerty", Status.GUEST, true));
        add(new User(2, "Aladiel", "El Safir De laCarug Fon De Sinior La Cruuazzor",
                "Ivanovich1657", 57,
                "andro@mail.ru", "87654321", Status.USER, false));
        add(new User(3, "Don", "Alexandro", "AlexAlexandro", 8,
                "andro@gmail.com", "!wDsf^h(53fnfi^Yfdd5K&!*", Status.USER, true));
        add(new User(4, "ALex", "Filatov", "AlexAlexandro", 18,
                "alexandro@yandex.ru", "f$fg2021", Status.VIP_USER, false));
        add(new User(5, "Dima", "Dragonov", "Dragon", 15,
                "drogo@rambler.ru", "Drago9090", Status.VIP_USER, true));
    }};

    public List<User> getUserList() {
        return userList;
    }
}
