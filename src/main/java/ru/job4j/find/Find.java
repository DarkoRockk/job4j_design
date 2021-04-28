package ru.job4j.find;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Find {
    public static void main(String[] args) throws IOException {
        String help = "Параметры поиска заданы неверно.\n"
                + "При запуске необходимо ввести 4 параметра в виде \"-d=c:/ -n=*.txt -t=mask -o=log.txt\", где:\n"
                + "-d - директория, в которой начинать поиск.\n"
                + "-n - имя файла, маска, либо регулярное выражение.\n"
                + "-t - тип поиска: mask искать по маске, name по полному совпадение имени, regex по регулярному выражению.\n"
                + "-o - результат записать в файл.\n"
                + "Пожалуйста перезапустите программу с верными параметрами.";
        if (args.length != 4) {
            System.out.println(help);
            return;
        } else if (!args[0].contains("-d=") || !args[1].contains("-n=") || !args[2].contains("-t=") || !args[3].contains("-o=")) {
            System.out.println(help);
            return;
        }
        List<String> allArgs = new ArrayList<>();
        for (String el : args) {
            allArgs.add(el.substring(el.indexOf("=") + 1));
        }
        SearchVisitor visitor = new SearchVisitor(allArgs.get(1), allArgs.get(2));
        Files.walkFileTree(Path.of(allArgs.get(0)), visitor);
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(allArgs.get(3)))) {
            for (FileElement el : visitor.getFiles()) {
                writer.println(el.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Поиск завершен.\n"
        + "Проверьте результат в" + Path.of(allArgs.get(3)).toAbsolutePath());
    }
}
