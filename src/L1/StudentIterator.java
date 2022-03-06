package L1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StudentIterator implements Iterator<Student> {
    private final Student[] array;
    private int pos = 0;

    public StudentIterator(Student[] array) {
        this.array = array;
    }

    public void setMark(double mark) {
        if(pos > 0) {
            array[pos - 1].setMark(mark);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void reset() {
        pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos < array.length;
    }

    @Override
    public Student next() {
        if(hasNext()) {
            return array[pos++];
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
