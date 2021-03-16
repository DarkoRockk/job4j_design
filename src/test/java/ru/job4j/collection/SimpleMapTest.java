package ru.job4j.collection;

import org.junit.Test;

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
        int rsl2 = map.get("Alien");
        assertThat(rsl1, is(3000));
        assertThat(rsl2, is(2000));
    }

    @Test
    public void whenDeleted() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.insert("Alien", 2000);
        boolean rsl1 = map.delete("Alien");
        boolean rsl2 = map.delete("Alien");
        assertThat(rsl1, is(true));
        assertThat(rsl2, is(false));
    }

}