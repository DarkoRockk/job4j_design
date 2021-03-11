package ru.job4j.collection;

import java.util.*;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, birthday);
    }

    public static void main(String[] args) {
        User user1 = new User("Dmitry", 31, new GregorianCalendar(1989, 3, 9));
        User user2 = new User("Dmitry", 31, new GregorianCalendar(1989, 3, 9));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, 23);
        map.put(user2, 24);
        for (Map.Entry<User, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
