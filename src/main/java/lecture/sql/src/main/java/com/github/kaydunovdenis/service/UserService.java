package com.github.kaydunovdenis.service;

import com.github.kaydunovdenis.user.Status;
import com.github.kaydunovdenis.user.User;

import java.sql.SQLException;
import java.util.Collection;

public interface UserService {

    User create(String firstName, String lastName, String username, Status status, String email) throws SQLException, ClassNotFoundException;

    Collection<User> findAll() throws SQLException, ClassNotFoundException;
}