package org.cache.cacheWithTransaction;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VersionedValue {

    private String value;
    private long version;
}
