package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.*;

public class SimpleSetTest {

    @Test
    public void checkUnique() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("Вася");
        set.add("Вася");
        set.add("Петя");
        set.add(null);
        List<String> array = new ArrayList<>();
        for (String el : set) {
            array.add(el);
        }
        assertThat(array.contains("Вася"), is(true));
        assertThat(array.contains("Петя"), is(true));
        assertThat(array.contains(null), is(true));
        assertThat(array.size(), is(3));
    }
}