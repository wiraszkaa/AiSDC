package L1;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private final T[] array;
    private int pos;

    public ArrayIterator(T[] array) {
        this.array = array;
        this.pos = 0;
    }

    public T[] getArray() {
        return array;
    }

    public int getPos() {
        return pos;
    }

    @Override
    public boolean hasNext() {
        return pos < array.length;
    }

    @Override
    public T next() {
        return array[pos++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
