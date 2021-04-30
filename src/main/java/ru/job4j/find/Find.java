package ru.job4j.find;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class Find {

    public static Predicate<Path> getPredicte(String arg1, String arg2) {
        if (arg1.equals("mask")) {
            return p -> p.toString().split("/")[p.toString().split("/").length - 1]
                    .contains(arg2.substring(arg2.indexOf("*") + 1));

        } else if (arg1.equals("regex")) {
            return p -> p.toString().split("/")[p.toString().split("/").length - 1]
                    .matches(arg2);
        } else {
            return p -> p.toString().split("/")[p.toString().split("/").length - 1]
                    .equals(arg2);
        }
    }

    public static SearchVisitor search(String path, Predicate<Path> condition) throws IOException {
        SearchVisitor visitor = new SearchVisitor(condition);
        Files.walkFileTree(Path.of(path), visitor);
        return visitor;
    }

    public static void write(String path, SearchVisitor visitor) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(path))) {
            for (FileElement el : visitor.getFiles()) {
                writer.println(el.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> allArgs = new ArgsValidation(args).getAllArgs();
        write(allArgs.get(3), search(allArgs.get(0), getPredicte(allArgs.get(2), allArgs.get(1))));
        System.out.println("Поиск завершен.\n"
                + "Проверьте результат в " + Path.of(allArgs.get(3)).toAbsolutePath());
    }
}
