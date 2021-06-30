package ru.job4j.menuapp;


import java.util.*;

public class Menu<K, V> implements CRUD<K, V> {

    private List<Node<K, V>> menu = new LinkedList<>();

    @Override
    public boolean add(K parent, K node, V action) {
        boolean rsl;
        Optional<Node<K, V>> found = find(parent);
        if (found.isEmpty()) {
            menu.add(new Node<>(node, action, null));
            rsl = true;
        } else {
            Node<K, V> par = found.get();
            par.children.add(new Node<>(node, action, par));
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean remove(K node) {
        boolean rsl = false;
        Optional<Node<K, V>> found = find(node);
        if (found.isPresent()) {
            List<Node<K, V>> list = found.get().parent.children;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).key.equals(node)) {
                    found.get().parent.children.remove(i);
                }
            }

        }
        return rsl;
    }

    @Override
    public boolean update(K node, V action) {
        boolean rsl = false;
        Optional<Node<K, V>> found = find(node);
        if (found.isPresent()) {
            found.get().action = action;
            rsl = true;
        }
        return rsl;
    }

    @Override
    public V get(K node) {
        V rsl = null;
        Optional<Node<K, V>> found = find(node);
        if (found.isPresent()) {
            rsl = found.get().action;
        }
        return rsl;
    }

    private Optional<Node<K, V>> find(K key) {
        Optional<Node<K, V>> found = Optional.empty();
        Queue<Node<K, V>> queue = new LinkedList<>(menu);
        while (!queue.isEmpty()) {
            Node<K, V> el = queue.poll();
            if (Objects.equals(el.key, key)) {
                found = Optional.of(el);
                break;
            }
            queue.addAll(el.children);
        }
        return found;
    }

}
