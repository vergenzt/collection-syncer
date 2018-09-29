package com.github.vergenzt.syncable.collections;

import io.reactivex.Flowable;

/**
 * A remote set whose changes emit addition and removal events.
 */
public interface ObservableSet<ItemType> extends WriteableSet<ItemType> {
    /**
     * Gets a stream of items being added to the set.
     *
     * @return a Flowable that should remain open
     */
    Flowable<ItemType> additions();

    /**
     * Gets a stream of items being removed from the set.
     *
     * @return a Flowable that should remain open
     */
    Flowable<ItemType> removals();
}
