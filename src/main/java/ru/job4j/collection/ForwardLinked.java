package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T rsl = head.value;
        head = head.next;
        return rsl;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> prev = null;
        Node<T> current = head;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        if (prev == null) {
            head = null;
        } else {
            prev.next = null;
        }
        return current.value;
    }

    public boolean revert() {
        if (head == null || head.next == null) {
            return false;
        }
        Node<T> reversed = null;
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            current.next = reversed;
            reversed = current;
            current = next;
        }
        head = reversed;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
