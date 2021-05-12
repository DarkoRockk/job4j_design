package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.io.*;
import java.sql.*;


public class ConnectionDemo {

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Config config = new Config("./add.properties");
        config.load();
        String url = config.value("hibernate.connection.url");
        String login = config.value("hibernate.connection.username");
        String password = config.value("hibernate.connection.password");
        return DriverManager.getConnection(url, login, password);
    }

    public static void main(String[] args) throws Exception {


    }
}
