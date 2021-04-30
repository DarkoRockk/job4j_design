package ru.job4j.find;

import java.util.ArrayList;
import java.util.List;

public class ArgsValidation {
    private List<String> allArgs = new ArrayList<>();

    private final String help = "Параметры поиска заданы неверно.\n"
            + "При запуске необходимо ввести 4 параметра в виде \"-d=c:/ -n=*.txt -t=mask -o=log.txt\", где:\n"
            + "-d - директория, в которой начинать поиск.\n"
            + "-n - имя файла, маска, либо регулярное выражение.\n"
            + "-t - тип поиска: mask искать по маске, name по полному совпадение имени, regex по регулярному выражению.\n"
            + "-o - результат записать в файл.\n"
            + "Пожалуйста, перезапустите программу с верными параметрами.";

    public ArgsValidation(String[] args) {
        if (args.length != 4) {
            System.out.println(help);
            return;
        } else if (!args[0].contains("-d=") || !args[1].contains("-n=") || !args[2].contains("-t=") || !args[3].contains("-o=")) {
            System.out.println(help);
            return;
        }
        for (String el : args) {
            allArgs.add(el.substring(el.indexOf("=") + 1));
        }
    }

    public List<String> getAllArgs() {
        return allArgs;
    }
}
