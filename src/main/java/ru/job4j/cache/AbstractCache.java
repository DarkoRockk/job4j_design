package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        SoftReference<V> softR = new SoftReference<V>(value);
        cache.put(key, softR);
    }

    public V get(K key) {
        if (cache.get(key) == null) {
            put(key, load(key));
        }
        return cache.get(key).get();
    }

    protected abstract V load(K key);
}
