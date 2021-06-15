package ru.job4j.srp;

import java.sql.Connection;

public interface DBSelector {
    public void initConnection();
    public String getResult(Connection cn);
    public void printConsole(String content);
}
