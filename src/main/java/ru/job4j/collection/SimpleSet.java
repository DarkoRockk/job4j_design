package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> list = new SimpleArray<>();
    private int size = 0;
    private int modCount = 0;

    public boolean add(T value) {
        for (T el : list) {
            if (el.equals(value)) {
                return false;
            }
        }
        list.add(value);
        size++;
        modCount++;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int index = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) list.get(index++);
            }
        };
    }
}
