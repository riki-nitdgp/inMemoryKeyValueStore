package org.cache.cacheWithTransaction;

import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
public class Transaction {
    private Map<String, VersionedValue> readSet;
    private Map<String, String> writeSet;
    private Set<String> deleteSet;

    public Transaction() {
        this.readSet = new HashMap<>();
        this.writeSet = new HashMap<>();
        this.deleteSet = new HashSet<>();

    }
}
