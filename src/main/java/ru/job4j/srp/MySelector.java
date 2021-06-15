package ru.job4j.srp;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MySelector implements DBSelector {

    private Connection cn;

    public MySelector(Connection cn) {
        this.cn = cn;
    }

    @Override
    public void initConnection() {
        try (InputStream in = MySelector.class
                .getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getResult(Connection cn) {
        StringBuilder rsl = new StringBuilder();
        try (PreparedStatement statement = cn.prepareStatement(
                "select * from table1")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                rsl.append(resultSet.getString("name")).append("\n");
                rsl.append(resultSet.getString("subject")).append("\n");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rsl.toString();
    }

    @Override
    public void printConsole(String content) {
        System.out.println(content);
    }
}
