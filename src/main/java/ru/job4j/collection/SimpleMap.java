package ru.job4j.collection;

import java.util.*;

public class SimpleMap<K, V> implements Iterable<SimpleMap.Node> {

    private Node[] table = new Node[16];
    private int size = 0;
    private int modCount = 0;

    public boolean insert(K key, V value) {
        Node<K, V> newNode = new Node<>(key.hashCode(), key, value);
        int i = index(key);
        checkLength(table, i);
        if (table[i] == null) {
            table[i] = newNode;
            size++;
            modCount++;
            return true;
        }
        return false;
    }

    public V get(K key) {
        int i = index(key);
        if (table[i] == null) {
            throw new NoSuchElementException();
        }
        return (V) table[i].value;
    }

    public boolean delete(K key) {
        int i = index(key);
        if (table[i] == null) {
            return false;
        }
        table[i] = null;
        return true;
    }

    public void checkLength(Node[] table, int i) {
        while (i >= table.length) {
            Node[] table1 = new Node[table.length * 2];
            System.arraycopy(table, 0, table1, 0, table.length);
            this.table = table1;
        }
    }

    public int index(K key) {
        return hash(key) & (table.length);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public Iterator<Node> iterator() {
        return new Iterator<Node>() {

            int index = 0;
            int expectedModCount = modCount;


            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Node next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node rsl = null;
                while (index < size) {
                    if (table[index] != null) {
                        rsl = table[index++];
                        break;
                    }
                    index++;
                }

                return rsl;
            }
        };
    }

    protected static class Node<K, V> {
        int hash;
        K key;
        V value;

        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }
}
