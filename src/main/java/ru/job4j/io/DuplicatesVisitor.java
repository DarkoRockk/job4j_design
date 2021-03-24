package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Set<FileProperty> files = new HashSet<>();
    private List<FileProperty> rsl = new ArrayList<>();

    public List<FileProperty> getFiles() {
        return rsl;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String[] names = file.toAbsolutePath().toString().split("/");
        FileProperty property = new FileProperty(Files.size(file), names[names.length - 1]);
        if (files.contains(property)) {
            rsl.add(property);
        } else {
            files.add(property);
        }
        return super.visitFile(file, attrs);
    }
}
