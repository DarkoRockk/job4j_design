package ru.job4j.io;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.List;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void unavailableTest() throws IOException {
        File source = folder.newFile("server_log.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.printf("%s%n", "200 10:56:01");
            out.printf("%s%n", "500 10:57:01");
            out.printf("%s%n", "400 10:58:01");
            out.printf("%s%n", "200 10:59:01");
            out.printf("%s%n", "500 11:01:02");
            out.printf("%s%n", "200 11:02:02");
        }
        Analizy an = new Analizy();
        an.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:01;10:59:01;"
                + "11:01:02;11:02:02;"));
    }


}