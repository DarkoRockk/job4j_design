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
        SoftReference<V> rsl = cache.get(key);
        if (rsl == null) {
            put(key, load(key));
            rsl = cache.get(key);
        } else if (rsl.get() == null) {
            put(key, load(key));
            rsl = cache.get(key);
        }
        return rsl.get();
    }

    protected abstract V load(K key);
}
