package ru.job4j.menuapp;

public interface CRUD<K, V> {

    boolean add(K parent, K node, V action);
    boolean remove(K node);
    boolean update(K node, V action);
    V get(K node);
}
