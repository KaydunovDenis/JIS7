package com.github.kaydunovdenis;

import com.github.kaydunovdenis.service.UserService;
import com.github.kaydunovdenis.service.UserServiceImpl;
import com.github.kaydunovdenis.user.Status;
import com.github.kaydunovdenis.user.User;

import java.sql.SQLException;
import java.util.Collection;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserService userService = new UserServiceImpl();

        User user = userService.create("Art", "Stankevich", "Ticon", Status.VIP, "artzandr@mail.ru");
        System.out.println(user.toString());

        Collection<User> all = userService.findAll();
        all.forEach(System.out::println);
    }
}
