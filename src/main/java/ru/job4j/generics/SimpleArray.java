package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] data;
    private int point = 0;
    private int index = 0;

    public SimpleArray(int size) {
        this.data = new Object[size];
    }

    public void add(T model) {
        data[point++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, point);
        data[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, point);
        for (int i = index; i < point; i++) {
            data[i] = data[i + 1];
            data[point] = null;
            point--;
        }
    }

    public T get(int index) {
        return (T) data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return index <= point && data[index] != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) data[index++];
            }
        };
    }
}
