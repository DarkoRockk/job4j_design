package ru.job4j.collection;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenInsert() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.insert("Alien", 2000);
        int rsl = map.get("Alien");
        assertThat(rsl, is(2000));
    }

    @Test
    public void whenInsertSeveral() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.insert("Alien", 2000);
        map.insert("Z90", 3000);
        int rsl1 = map.get("Z90");
        assertThat(rsl1, is(3000));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleted() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.insert("Alien", 2000);
        map.delete("Alien");
        int rsl = map.get("Alien");
    }

}