package ru.job4j.jdbc;

import java.io.*;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectionDemo {

    public static Map<String, String> getParams(String source) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            while (reader.ready()) {
               lines.add(reader.readLine());
            }
        }
        Map<String, String> params = new HashMap<>();
        for (String line : lines) {
            if (line.contains("=")) {
                String[] param = line.split("=");
                if (param[0].contains("url")) {
                    params.put("url", param[1]);
                } else if (param[0].contains("username")) {
                    params.put("login", param[1]);
                } else if (param[0].contains("password")) {
                    params.put("password", param[1]);
                }
            }
        }
        return params;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.postgresql.Driver");
        Map<String, String> params = getParams("./add.properties");
        try (Connection connection = DriverManager.getConnection(params.get("url"), params.get("login"), params.get("password"))) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
