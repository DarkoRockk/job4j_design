package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedArray<T> implements Iterable<T> {

    transient int size = 0;
    transient Node<T> first;
    transient Node<T> last;
    private int modCount = 0;

    public void add(T model) {
        if (size == 0) {
            first = new Node<T>(null, model, null);
            last = first;
        } else {
            last = new Node<T>(first, model, null);
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        int point = size - 1;
        Node<T> rsl = last;
        while (point > index) {
            rsl = rsl.prev;
            point--;
        }
        modCount++;
        return rsl.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int index = size - 1;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(index--);
            }
        };
    }
}
