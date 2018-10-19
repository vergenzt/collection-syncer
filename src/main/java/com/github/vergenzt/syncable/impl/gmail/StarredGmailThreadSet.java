package com.github.vergenzt.syncable.impl.gmail;

import com.github.vergenzt.syncable.collections.SyncableSet;
import com.google.api.services.gmail.model.Thread;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class StarredGmailThreadSet implements SyncableSet<Thread> {
    @Override
    public Flowable<Thread> additions() {
        Thread
        return null;
    }

    @Override
    public Flowable<Thread> removals() {
        return null;
    }

    @Override
    public Single<Thread> add(Thread item) {
        return null;
    }

    @Override
    public Maybe<Thread> remove(Thread item) {
        return null;
    }

    @Override
    public Flowable<Thread> fetchAll() {
        return null;
    }
}
