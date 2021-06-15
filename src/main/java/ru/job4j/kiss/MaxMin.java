package ru.job4j.kiss;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return find(value, comparator, i -> i > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return find(value, comparator, i -> i < 0);
    }

    public <T> T find(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T rsl = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            if (predicate.test(comparator.compare(value.get(i), rsl))) {
                rsl = value.get(i);
            }
        }
        return rsl;
    }
}


