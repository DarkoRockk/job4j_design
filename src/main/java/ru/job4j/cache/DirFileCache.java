package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
        put(cachingDir, load(cachingDir));
    }

    @Override
    public String get(String key) {
        if (cache.get(key) == null) {
            super.put(key, load(key));
        }
        return super.get(key);
    }

    @Override
    public void put(String key, String value) {
        super.put(key, value);
    }

    @Override
    protected String load(String key) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(key))) {
            while (reader.ready()) {
                sb.append(reader.readLine()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
