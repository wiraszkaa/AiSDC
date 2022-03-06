package L1;

public class Zad3 {

    public ArrayIterator<Student> addStudent(ArrayIterator<Student> studentIterator, Student student) {
        Student[] students = new Student[studentIterator.getArray().length - studentIterator.getPos() + 1];
        int index = 0;
        while(studentIterator.hasNext()) {
            students[index] = studentIterator.next();
            index++;
        }
        students[students.length - 1] = student;
        return new ArrayIterator<>(students);
    }

    public ArrayIterator<Student> removeStudent(ArrayIterator<Student> studentIterator, Student removeStudent) {
        Student[] studentsRemoved = new Student[studentIterator.getArray().length - studentIterator.getPos() - 1];
        Student[] studentsNotRemoved = new Student[studentIterator.getArray().length - studentIterator.getPos()];
        boolean flag = false;
        int index = 0;
        int counter = 0;
        while(studentIterator.hasNext()) {
            Student student = studentIterator.next();
            if(student != removeStudent) {
                if(index < studentsRemoved.length) {
                    studentsRemoved[index] = student;
                    index++;
                }
            } else {
                flag = true;
            }
            studentsNotRemoved[counter] = student;
            counter++;
        }
        if(flag) {
            return new ArrayIterator<>(studentsRemoved);
        } else {
            return new ArrayIterator<>(studentsNotRemoved);
        }
    }

    public ArrayIterator<Student> sortMarksDescending(ArrayIterator<Student> studentIterator) {
        Student[] students = new Student[studentIterator.getArray().length - studentIterator.getPos()];
        int index = 0;
        while(studentIterator.hasNext()) {
            students[index] = studentIterator.next();
            index++;
        }

        int n = students.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getMark() < students[j + 1].getMark()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        return new ArrayIterator<>(students);
    }
}
