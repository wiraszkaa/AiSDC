package L1;

import java.util.ArrayList;

public class Zad2 {
    private final StudentZad2[] students;

    public Zad2(StudentZad2[] students) {
        this.students = students;
    }

    public void showStudents() {
        ArrayIterator<StudentZad2> studentIterator = new ArrayIterator<>(students);
        while(studentIterator.hasNext()) {
            System.out.println(studentIterator.next());
        }
    }

    public void addStudentMark(int index, double mark) {
        FilterIterator<StudentZad2> studentIterator = new FilterIterator<>(new ArrayIterator<>(students), (student) -> student.getIndex() == index);
        while(studentIterator.hasNext()) {
            studentIterator.next().addMark(mark);
        }
    }

    public void avgPositiveMark() {
        FilterIterator<StudentZad2> studentIterator = new FilterIterator<>(new ArrayIterator<>(students), (student) -> student.getAverageMark() >= 3);
        ArrayList<Double> allMarks = new ArrayList<>();
        while (studentIterator.hasNext()) {
            allMarks.addAll(studentIterator.next().getMarks());
        }
        double avg = allMarks.stream().mapToDouble((val) -> val).sum() / allMarks.size();
        System.out.println("Average Positive Mark= " + avg);
    }

    public void showNotPassedStudents() {
        FilterIterator<StudentZad2> studentIterator = new FilterIterator<>(new ArrayIterator<>(students), (student) -> student.getAverageMark() < 3);
        while (studentIterator.hasNext()) {
            System.out.println(studentIterator.next());
        }
    }
}
