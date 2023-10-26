package edu.hw3;

import java.util.Iterator;
import java.util.List;

public class Task8<T> implements Iterator<T> {

    private final List<T> collection;
    private int cursor;

    public Task8(List<T> collection) {
        this.collection = collection;
        this.cursor = collection.size();
    }

    @Override
    public boolean hasNext() {
        return 0 < cursor;
    }

    @Override
    public T next() {
        if (hasNext()) {
            cursor--;
            return collection.get(cursor);
        }
        return collection.get(cursor);
    }

}
