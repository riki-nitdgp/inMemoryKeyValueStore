package org.cache.lru.exception;

public class KeyNotFoundException extends RuntimeException {

    public KeyNotFoundException(String  message) {
        super(message);
    }
}
