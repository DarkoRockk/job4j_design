package ru.job4j.collection;

import java.util.Calendar;
import java.util.Objects;

public class User {

    private String name;
    private int age;
    private Calendar birthday;

    public User(String name, int age, Calendar birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Calendar getBirthday() {
        return birthday;
    }
}
