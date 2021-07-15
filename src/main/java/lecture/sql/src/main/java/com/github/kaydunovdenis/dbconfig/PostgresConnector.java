package com.github.kaydunovdenis.dbconfig;

import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@AllArgsConstructor
public class PostgresConnector {
    public static final String USERNAME = "postgres";
    public static final String PASS = "Warden2021!";
    public static final String URL = "jdbc:postgresql://localhost:5432/user";

    static Connection connection;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return connection =  DriverManager.getConnection(URL, USERNAME, PASS);
    }

    public static Statement getStatement() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection =  DriverManager.getConnection(URL, USERNAME, PASS);
        return connection.createStatement();
    }
}