package L1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StudentZad2Iterator implements Iterator<StudentZad2> {
    private final StudentZad2[] array;
    private int pos = 0;

    public StudentZad2Iterator(StudentZad2[] array) {
        this.array = array;
    }

    public void addMark(double mark) {
        array[pos - 1].addMark(mark);
    }

    public void reset() {
        pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos < array.length;
    }

    @Override
    public StudentZad2 next() {
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
