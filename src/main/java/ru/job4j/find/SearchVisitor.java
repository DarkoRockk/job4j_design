package ru.job4j.find;

import ru.job4j.io.FileProperty;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchVisitor extends SimpleFileVisitor<Path> {
    private Predicate<Path> condition;
    private List<FileElement> rsl = new ArrayList<>();

    public SearchVisitor(Predicate<Path> condition) {
        this.condition = condition;
    }

    public List<FileElement> getFiles() {
        return rsl;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (condition.test(file.toAbsolutePath())) {
            FileElement element = new FileElement(file.toAbsolutePath().toString());
            rsl.add(element);
        }
        return super.visitFile(file, attrs);
    }
}
