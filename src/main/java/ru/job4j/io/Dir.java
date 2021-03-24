package ru.job4j.io;

import java.io.File;

public class Dir {

    public static void main(String[] args) {
        File file = new File("/Users/darkorockk/IdeaProjects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File subfile : file.listFiles()) {
            String[] path = subfile.getPath().split("/");
            System.out.println(String.format("%s with size: %s",
                    path[path.length - 1],
                    subfile.length()));
        }
    }
}
