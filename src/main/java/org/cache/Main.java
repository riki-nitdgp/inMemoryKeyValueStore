package org.cache;

import org.cache.cacheWithTransaction.KeyValueStore;

public class Main {
    public static void main(String[] args) {
        KeyValueStore keyValueStore = new KeyValueStore();
        keyValueStore.set("key1", "value1");
        keyValueStore.set("key2", "value2");
        keyValueStore.begin();
        keyValueStore.set("key2", "value2.1");
        keyValueStore.rollback();
        System.out.println(keyValueStore.get("key2"));

    }
}