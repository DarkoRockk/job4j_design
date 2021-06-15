package ru.job4j.kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class MaxMinTest {

    @Test
    public void checkMax() {
        MaxMin maxmin = new MaxMin();
        List<Integer> list = List.of(1, 4, 5, 6, 8);
        int rsl = maxmin.max(list, Comparator.naturalOrder());
        assertThat(rsl, is(8));
    }

    @Test
    public void checkMin() {
        MaxMin maxmin = new MaxMin();
        List<Integer> list = List.of(1, 4, 5, 6, 8);
        int rsl = maxmin.min(list, Comparator.naturalOrder());
        assertThat(rsl, is(1));
    }
}