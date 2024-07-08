package org.cache.lru.storage;

import org.coding.systemDesign.cache.exception.CacheStorageFullException;
import org.coding.systemDesign.cache.exception.KeyNotFoundException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapBasedStore<KEY, VALUE> implements IStorage<KEY, VALUE> {

    private Map<KEY, VALUE> map;
    private final int capacity;

    public HashMapBasedStore(int capacity) {
        this.map = new ConcurrentHashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void set(KEY key, VALUE value) {
        if(this.isStorageFull()) {
            throw new CacheStorageFullException("Capacity is full");
        }
        this.map.put(key, value);
    }

    @Override
    public VALUE get(KEY key) {
        if(!isKeyExist(key)) { throw new KeyNotFoundException("Key Not Found"); }
        return this.map.get(key);
    }

    @Override
    public void delete(KEY key) {
        if(!isKeyExist(key)) { throw new KeyNotFoundException("Key Not Found"); }
        this.map.remove(key);
    }

    private boolean isStorageFull() {
        return this.map.size() >= this.capacity;
    }

    private boolean isKeyExist(KEY key) {
        return this.map.containsKey(key);
    }
}
