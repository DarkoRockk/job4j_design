package ru.job4j.generics;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class UserStoreTest {

    @Test
    public void whenFindById() {
        UserStore store = new UserStore();
        store.add(new User("123"));
        User expected = new User("123");
        assertThat(expected, is(store.findById("123")));
    }

    @Test
    public void whenReplace() {
        UserStore store = new UserStore();
        store.add(new User("123"));
        store.replace("123", new User("456"));
        User expected = new User("456");
        assertThat(expected, is(store.findById("456")));
    }

    @Test
    public void whenDelete() {
        UserStore store = new UserStore();
        store.add(new User("123"));
        store.delete("123");
        assertThat(null, is(store.findById("123")));
    }

}