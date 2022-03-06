package L1;

import java.util.ArrayList;

public class Zad2 {
    private final StudentZad2Iterator studentIterator;

    public Zad2(StudentZad2[] students) {
        this.studentIterator = new StudentZad2Iterator(students);
    }

    public void showStudents() {
        studentIterator.reset();
        while(studentIterator.hasNext()) {
            System.out.println(studentIterator.next());
        }
    }

    public void addStudentMark(int index, double mark) {
        studentIterator.reset();
        while(studentIterator.hasNext()) {
            if(studentIterator.next().getIndex() == index) {
                studentIterator.addMark(mark);
            }
        }
    }

    public void avgPositiveMark() {
        studentIterator.reset();
        ArrayList<Double> allMarks = new ArrayList<>();
        while (studentIterator.hasNext()) {
            StudentZad2 student = studentIterator.next();
            if(student.getAverageMark() >= 3) {
                allMarks.addAll(student.getMarks());
            }
        }
        double avg = allMarks.stream().mapToDouble((val) -> val).sum() / allMarks.size();
        System.out.println("Average Positive Mark= " + avg);
    }

    public void showNotPassedStudents() {
        studentIterator.reset();
        while (studentIterator.hasNext()) {
            StudentZad2 student = studentIterator.next();
            if(student.getAverageMark() < 3) {
                System.out.println(student);
            }
        }
    }
}
