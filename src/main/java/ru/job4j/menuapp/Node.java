package ru.job4j.menuapp;

import java.util.LinkedList;
import java.util.List;

public class Node<K, V> implements Action, Printable {

    K key;
    V action;
    Node<K, V> parent;
    List<Node<K, V>> children = new LinkedList<>();

    public Node(K key, V action, Node<K, V> parent) {
        this.key = key;
        this.action = action;
        this.parent = parent;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public void act() {

    }

    @Override
    public String unOrdered() {
        return null;
    }
}
