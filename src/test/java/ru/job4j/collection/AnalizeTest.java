package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;

import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void checkInfo() {
        List<Analize.User> previous = new ArrayList<Analize.User>(List.of(
                new Analize.User(1, "Dmitry"),
                new Analize.User(2, "Viktoria"),
                new Analize.User(3, "Viktoria")
        ));
        List<Analize.User> current = new ArrayList<Analize.User>(List.of(
                new Analize.User(2, "Viktoria"),
                new Analize.User(3, "Dmitry"),
                new Analize.User(4, "Boris")
        ));
        Analize.Info info = Analize.diff(previous, current);
        assertThat(1, is(info.added));
        assertThat(1, is(info.changed));
        assertThat(1, is(info.deleted));
    }

    @Test
    public void ifEmptyList() {
        List<Analize.User> previous = new ArrayList<Analize.User>();
        List<Analize.User> current = new ArrayList<Analize.User>(List.of(
                new Analize.User(2, "Viktoria"),
                new Analize.User(3, "Dmitry"),
                new Analize.User(4, "Boris")
        ));
        Analize.Info info = Analize.diff(previous, current);
        assertThat(3, is(info.added));
        assertThat(0, is(info.changed));
        assertThat(0, is(info.deleted));
    }

    @Test
    public void ifNothingChange() {
        List<Analize.User> previous = new ArrayList<Analize.User>();
        List<Analize.User> current = new ArrayList<Analize.User>();
        Analize.Info info = Analize.diff(previous, current);
        assertThat(0, is(info.added));
        assertThat(0, is(info.changed));
        assertThat(0, is(info.deleted));
    }

}