package ru.job4j.menuapp;


public class Menu<K, V> implements CRUD<K,V> {

    @Override
    public boolean add(K parent, K node, V action) {
        return false;
    }

    @Override
    public boolean remove(K node) {
        return false;
    }

    @Override
    public boolean update(K node, V action) {
        return false;
    }

    @Override
    public V get(K node) {
        return null;
    }
}
