package com.github.vergenzt.syncable.pipes;

import com.github.vergenzt.syncable.collections.SyncableSet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * A connection between two SyncableSets that synchronizes changes between the two.
 *
 * @param <A> the item type of the first set
 * @param <B> the item type of the second set
 */
public class TwoWayPipe<A, B> {
    private OneWayPipe<A, B> pipeAtoB;
    private OneWayPipe<B, A> pipeBtoA;

    public TwoWayPipe(SyncableSet<A> setA, SyncableSet<B> setB, ConversionFunction<A, B> aToB, ConversionFunction<B, A> bToA) {
        this.pipeAtoB = new OneWayPipe<>(setA, setB, aToB);
        this.pipeBtoA = new OneWayPipe<>(setB, setA, bToA);
    }

    public Disposable subscribe() {
        return new CompositeDisposable(
            this.pipeAtoB.subscribe(),
            this.pipeBtoA.subscribe()
        );
    }
}
