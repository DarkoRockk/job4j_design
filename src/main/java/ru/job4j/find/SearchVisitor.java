package ru.job4j.find;

import ru.job4j.io.FileProperty;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchVisitor extends SimpleFileVisitor<Path> {
    String name;
    String searchType;
    private List<FileElement> rsl = new ArrayList<>();

    public SearchVisitor(String name, String searchType) {
        this.name = name;
        this.searchType = searchType;
    }

    public List<FileElement> getFiles() {
        return rsl;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String[] names = file.toAbsolutePath().toString().split("/");
        FileElement element = new FileElement(file.toAbsolutePath().toString());
        //FileElement element = new FileElement(names[names.length - 1]);
        if (searchType.equals("mask")) {
            if (names[names.length - 1].contains(name.substring(name.indexOf("*") + 1))) {
                rsl.add(element);
            }
        } else if (searchType.equals("regex")) {
            if (names[names.length - 1].matches(name)) {
                rsl.add(element);
            }
        } else {
            if (names[names.length - 1].equals(name)) {
                rsl.add(element);
            }
        }
        return super.visitFile(file, attrs);
    }
}
