package L1;

import java.util.Iterator;

public class FilterIterator<T> implements Iterator<T> {

    private final Iterator<T> iterator;
    private final Predicate<T> predicate;
    private T next;
    private boolean predicateHasNext;

    public FilterIterator(Iterator<T> iterator, Predicate<T> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
        this.predicateHasNext = true;
        findNextValid();
    }

    private void findNextValid() {
        while (iterator.hasNext()) {
            next = iterator.next();
            if (predicate.accept(next)) {
                return;
            }
        }
        next = null;
        predicateHasNext = false;
    }

    @Override
    public boolean hasNext() {
        return predicateHasNext;
    }

    @Override
    public T next() {
        T nextValue = next;
        findNextValid();
        return nextValue;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
