package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "/Users/darkorockk/IdeaProjects/job4j_design/without_comments.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
    }

    @Test
    public void whenPairWithComment() {
        String path = "/Users/darkorockk/IdeaProjects/job4j_design/add.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIllegalArgument() {
        String path = "/Users/darkorockk/IdeaProjects/job4j_design/illegal.properties";
        Config config = new Config(path);
        config.load();
    }
}