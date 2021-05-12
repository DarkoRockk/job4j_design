package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {
    private Connection connection;

    private Properties properties;

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Config config = new Config("./add.properties");
        config.load();
        String url = config.value("hibernate.connection.url");
        String login = config.value("hibernate.connection.username");
        String password = config.value("hibernate.connection.password");
        return DriverManager.getConnection(url, login, password);
    }

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws SQLException, ClassNotFoundException {
        connection = getConnection();
    }

    public void createTable(String tableName) throws Exception {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("create table %s();", tableName);
            statement.execute(sql);
        }
    }

    public void dropTable(String tableName) throws Exception {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("drop table %s();", tableName);
            statement.execute(sql);
        }
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("alter table %s add column %s %s;", tableName, columnName, type);
            statement.execute(sql);
        }
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("alter table %s drop column %s;", tableName, columnName);
            statement.execute(sql);
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format("alter table %s rename column %s to %s;", tableName, columnName, newColumnName);
            statement.execute(sql);
        }
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
