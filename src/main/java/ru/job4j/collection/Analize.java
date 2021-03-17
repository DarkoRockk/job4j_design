package ru.job4j.collection;

import java.util.*;

public class Analize {

    public static Info diff(List<User> previous, List<User> current) {
        Info rsl = new Info();
        Map<Integer, String> users = new HashMap<>();
        int counter = 0;
        for (User el : previous) {
            users.put(el.id, el.name);
        }
        for (User el : current) {
            String name = users.get(el.id);
            if (name == null) {
                rsl.added++;
            } else if (!name.equals(el.name)) {
                rsl.changed++;
                counter++;
            } else if (name.equals((el.name))) {
                counter++;
            }
        }
        rsl.deleted = previous.size() - counter;
        return rsl;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}
