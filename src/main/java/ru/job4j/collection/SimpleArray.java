package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private transient Object[] data = new Object[1];
    private int point = 0;
    private int modCount = 0;

    public void add(T model) {
        if (point == data.length) {
            Object[] data1 = new Object[point + 1];
            System.arraycopy(data, 0, data1, 0, data.length - 1);
            data = data1;
        }
        data[point++] = model;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, point);
        modCount++;
        return (T) data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int index = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return index < point;
            }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) data[index++];
            }
        };
    }
}
