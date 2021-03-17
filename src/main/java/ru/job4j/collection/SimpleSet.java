package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> list = new SimpleArray<>();


    public boolean add(T value) {
        if (!contains(value)) {
            list.add(value);
            return true;
        }
        return false;
    }

    public boolean contains(T value) {

        for (T el : list) {
            if (Objects.equals(el, value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
