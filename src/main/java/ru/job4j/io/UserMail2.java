package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class UserMail2 {

    private Map<String, Set<String>> users = new HashMap<>();
    private List<String> names = new ArrayList();

    public UserMail2(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                String user = reader.readLine();
                String[] key = user.split("=");
                if (key.length != 2) {
                    throw new IllegalArgumentException();
                }
                String[] values = key[1].split(",");
                users.put(key[0], Set.of(values));
                names.add(key[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void merge() {
        if (names.size() < 2) {
            return;
        }
        for (int i = 0; i < names.size(); i++) {
            if (i == names.size() - 1) {
                break;
            }
            for (int j = i + 1; j < names.size();) {
                Set<String> set1 = users.get(names.get(i));
                Set<String> set2 = users.get(names.get(j));
                Set<String> set3 = new HashSet<>();
                if (!Collections.disjoint(set1, set2)) {
                    set3.addAll(set1);
                    set3.addAll(set2);
                    users.put(names.get(i), set3);
                    names.remove(j);
                } else {
                    j++;
                }
            }
        }
    }

    public List<String> getResult() {
        List<String> rsl = new ArrayList();
        for (String user : names) {
            String name = user + "=";
            for (String email : users.get(user)) {
                name += email + ",";
            }
            rsl.add(name);
        }
        return rsl;
    }

    public static void main(String[] args) {
        UserMail2 mails = new UserMail2("./users.txt");
        mails.merge();
        for (String user : mails.getResult()) {
            System.out.println(user);
        }

    }
}
