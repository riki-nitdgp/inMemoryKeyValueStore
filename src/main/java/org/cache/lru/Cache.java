package org.cache.lru;

import org.coding.systemDesign.cache.exception.CacheStorageFullException;
import org.coding.systemDesign.cache.exception.KeyNotFoundException;
import org.coding.systemDesign.cache.policy.EvictionPolicy;
import org.coding.systemDesign.cache.storage.IStorage;

public class Cache<KEY, VALUE> {

    private final EvictionPolicy<KEY> evictionPolicy;
    private final IStorage<KEY, VALUE> store;

    public Cache(EvictionPolicy<KEY> evictionPolicy, IStorage<KEY, VALUE> store) {
        this.evictionPolicy = evictionPolicy;
        this.store = store;
    }

    public VALUE get(KEY key) {
        try {
            VALUE value = this.store.get(key);
            this.evictionPolicy.accessedKey(key);
            return value;
        } catch (KeyNotFoundException e) {
            System.out.println("Key Not Found");
            return null;
        }
    }

    public void set(KEY key, VALUE value) {
        try {
            this.store.set(key, value);
            this.evictionPolicy.accessedKey(key);
            return;
        } catch (CacheStorageFullException ex) {
            KEY keyToRemove = this.evictionPolicy.evict();
            if (keyToRemove == null) {
                throw new RuntimeException("Unexpected State. Storage full and no key to evict.");
            }
            this.store.delete(keyToRemove);
            this.set(key, value);
        }
    }
}
