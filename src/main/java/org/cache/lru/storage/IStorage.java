package org.cache.lru.storage;

public interface IStorage<KEY, VALUE> {
    void set(KEY key, VALUE value);
    VALUE get(KEY key);
    void delete(KEY key);

}
