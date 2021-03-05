package ru.job4j.collection;

import java.util.Iterator;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        T rsl = null;
        Iterator<T> it = linked.iterator();
        while (it.hasNext()) {
            rsl = it.next();
        }
        linked.deleteLast();
        return rsl;
    }

    public void push(T value) {
        linked.add(value);
    }
}
