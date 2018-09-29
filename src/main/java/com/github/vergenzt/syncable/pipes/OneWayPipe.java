package com.github.vergenzt.syncable.pipes;

import com.github.vergenzt.syncable.collections.SyncableSet;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * A connection between two SyncableSets that synchronizes changes in one direction.
 *
 * @param <A> the item type of the first set
 * @param <B> the item type of the second set
 */
public class OneWayPipe<T, O> {
    private SyncableSet<T> thisSet;
    private SyncableSet<O> otherSet;
    private ConversionFunction<T,O> tToO;

    private Flowable<T> additions;
    private Flowable<T> removals;

    public OneWayPipe(SyncableSet<T> thisSet, SyncableSet<O> otherSet, ConversionFunction<T, O> tToO) {
        this.thisSet = thisSet;
        this.otherSet = otherSet;
        this.tToO = tToO;
    }

    public Disposable subscribe() {
        return new CompositeDisposable(
            thisSet.additions().subscribe(this::handleAddition),
            thisSet.removals().subscribe(this::handleRemoval)
        );
    }

    private void handleAddition(T item) {
        this.tToO.convert(item).map(this.otherSet::add);
    }

    private void handleRemoval(T item) {
        this.tToO.convert(item).map(this.otherSet::remove);
    }
}

