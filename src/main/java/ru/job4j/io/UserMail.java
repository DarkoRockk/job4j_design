package ru.job4j.io;

import org.w3c.dom.ls.LSOutput;
import ru.job4j.generics.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class UserMail {
    private Map<String, List<String>> users = new HashMap<>();


    public UserMail(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                String user = reader.readLine();
                String[] key = user.split("=");
                if (key.length != 2) {
                    throw new IllegalArgumentException();
                }
                String[] values = key[1].split(",");
                users.put(key[0], List.of(values));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void merge() {
        Map<String, List<String>> mail = new HashMap<>();
        Map<String, List<String>> rsl = new HashMap<>();
        for (Map.Entry<String, List<String>> pair : users.entrySet()) {
            for (String el : pair.getValue()) {
                if (!mail.containsKey(el)) {
                    mail.get(el).add(pair.getKey());
                } else {
                    mail.put(el, new ArrayList<>(List.of(pair.getKey())));
                }
            }
        }
        for (Map.Entry<String, List<String>> pair : mail.entrySet()) {
            if (pair.getValue().size() > 1) {
                String key = pair.getValue().get(0);
                Set<String> set = new HashSet<>();
                for (String el : pair.getValue()) {
                    if (users.containsKey(el)) {
                        set.addAll(users.get(el));
                        users.remove(el);
                    }
                }
                rsl.put(key, List.copyOf(set));
            }
        }
        rsl.forEach(users::put);
        for (Map.Entry<String, List<String>> pair : rsl.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }


    public static void main(String[] args) {
        UserMail mails = new UserMail("./users.txt");
        mails.merge();

    }
}
