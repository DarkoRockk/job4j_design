package ru.job4j.io;

import java.util.LinkedList;
import java.util.StringJoiner;

public class Shell {
    private LinkedList<String> res = new LinkedList<>();

    public void cd(String path) {

        if (path.startsWith("/")) {
            parseAbsolute(path);
        } else {
            parseRelative(path);
        }
    }

    void parseAbsolute(String path) {
        res.clear();
        if (path.equals("/")) {
            res.clear();
        }
        if (path.startsWith("/")) {
            String[] str;
            str = path.split("/");
            for (String s : str) {
                if (s.equals("")) {
                    continue;
                }
                res.addLast(s);
            }
        }
    }

    void parseRelative(String path) {
        if (!path.equals("/") && !path.startsWith("/")) {
            String[] str;
            str = path.split("/");
            for (String s : str) {
                if (s.equals("..")) {
                    res.removeLast();
                } else {
                    res.addLast(s);
                }
            }
        }
    }

    public String pwd() {
        StringJoiner sj = new StringJoiner("/", "/", "");
        while (!res.isEmpty()) {
            sj.add(res.pollFirst());
        }
        return sj.toString();
    }
}
