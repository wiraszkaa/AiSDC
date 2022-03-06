package L1;


public class Zad1 {
    private final Student[] students;

    public Zad1(Student[] students) {
        this.students = students;
    }

    public void showStudents() {
        ArrayIterator<Student> studentIterator = new ArrayIterator<>(students);
        while(studentIterator.hasNext()) {
            System.out.println(studentIterator.next());
        }
    }

    public void setStudentMark(int index, double mark) {
        FilterIterator<Student> studentIterator = new FilterIterator<>(new ArrayIterator<>(students), (student) -> student.getIndex() == index);
        while(studentIterator.hasNext()) {
            studentIterator.next().setMark(mark);
        }
    }

    public void avgPositiveMark() {
        FilterIterator<Student> studentIterator = new FilterIterator<>(new ArrayIterator<>(students), (student) -> student.getMark() >= 3);
        double markSum = 0;
        double studentNum = 0;
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            markSum += student.getMark();
            studentNum++;
        }
        System.out.println("Average Positive Mark= " + markSum/studentNum);
    }

    public void showNotPassedStudents() {
        FilterIterator<Student> studentIterator = new FilterIterator<>(new ArrayIterator<>(students), (student) -> student.getMark() < 3);
        while(studentIterator.hasNext()) {
            System.out.println(studentIterator.next());
        }
    }
}
