package org.cache.lru.policy;

public interface EvictionPolicy<KEY> {

    void accessedKey(KEY key);

    KEY evict();

}
