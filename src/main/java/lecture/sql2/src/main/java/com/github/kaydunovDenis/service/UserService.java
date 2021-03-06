package com.github.kaydunovDenis.service;

import com.github.kaydunovDenis.user.Status;
import com.github.kaydunovDenis.user.User;

import java.sql.SQLException;
import java.util.Collection;

public interface UserService {

    User create(String firstName, String lastName, String username, Status status, String email) throws SQLException, ClassNotFoundException;

    Collection<User> findAll() throws SQLException, ClassNotFoundException;
}