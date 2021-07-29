package com.github.kaydunovDenis;

import com.github.kaydunovDenis.service.UserService;
import com.github.kaydunovDenis.service.UserServiceImpl;
import com.github.kaydunovDenis.user.Status;
import com.github.kaydunovDenis.user.User;


import java.sql.SQLException;
import java.util.Collection;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserService userService = new UserServiceImpl();

        User user = userService.create("Art", "Stankevich", "Timon", Status.VIP, "artzandr@mail.ru");
        System.out.println(user.toString());

        Collection<User> all = userService.findAll();
        all.forEach(System.out::println);
    }
}

