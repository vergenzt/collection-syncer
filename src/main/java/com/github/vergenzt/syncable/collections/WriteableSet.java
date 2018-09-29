package com.github.vergenzt.syncable.collections;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * A remote set that is mutable via its add and remove methods.
 */
public interface WriteableSet<ItemType> {

    /**
     * Attempts to add an item to the set.
     *
     * Should be idempotent.
     *
     * Note that the returned item object may not be strictly equal to the one provided
     * e.g. if properties have changed, or if there are different representations for
     * items in the set vs not in the set.
     *
     * E.g. for RTM, a NewTask parameter may be returned as an ExistingTask
     *
     * @param item
     * @return the added item
     */
    Single<ItemType> add(ItemType item);

    /**
     * Attempts to remove an item from the set.
     *
     * Should be idempotent.
     *
     * Note that the returned item object may not be strictly equal to the one provided
     * e.g. if properties have changed, or if there are different representations for
     * items in the set vs not in the set.
     *
     * @param item
     * @return the removed item
     */
    Maybe<ItemType> remove(ItemType item);
}
