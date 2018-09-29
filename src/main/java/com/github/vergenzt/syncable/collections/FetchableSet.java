package com.github.vergenzt.syncable.collections;

import io.reactivex.Flowable;

/**
 * A remote set whose full contents are fetchable into memory.
 */
public interface FetchableSet<ItemType> {
    /**
     * Refetches the full contents of the set into an in-memory representation.
     *
     * @return a flowable that completes when the full set has been fetched
     */
    Flowable<ItemType> fetchAll();
}
