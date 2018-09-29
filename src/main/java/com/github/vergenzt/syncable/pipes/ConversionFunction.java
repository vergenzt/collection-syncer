package com.github.vergenzt.syncable.pipes;

import io.reactivex.Single;

public interface ConversionFunction<A, B> {
    /**
     * Convert an item type from one set into an item type of another set.
     *
     * Note that the item returned need not be a member of the second set, just the right type.
     *
     * @param item
     * @return an item of the other set's type
     */
    Single<B> convert(A item);
}
