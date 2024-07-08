package org.cache.lru.exception;

public class CacheStorageFullException extends RuntimeException{
    public CacheStorageFullException(String message) {
        super(message);
    }
}
