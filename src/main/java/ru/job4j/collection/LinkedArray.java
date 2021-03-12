package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedArray<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> first;
    private Node<T> last;
    private int modCount = 0;

    public void add(T model) {
        if (size == 0) {
            first = new Node<T>(null, model, null);
            last = first;
        } else {
            Node<T> newNode = new Node<>(last, model, null);
            last.next = newNode;
            last = newNode;
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
        return rsl.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int index = 0;
            int expectedModCount = modCount;
            Node<T> target = first;


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
                Node<T> rsl = target;
                target = target.next;
                index++;
                return rsl.item;
            }
        };
    }
}
