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
        V rsl = null;
        if (!cache.containsKey(key)) {
            put(key, load(key));
            rsl = cache.get(key).get();
        } else if (cache.get(key).get() == null) {
            put(key, load(key));
            rsl = cache.get(key).get();
        }
        return rsl;
    }

    protected abstract V load(K key);
}
