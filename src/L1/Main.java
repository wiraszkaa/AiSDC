package L1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student student0 = new Student(0, "Todd", "Mark");
        Student student1 = new Student(1, "Price", "Tim");
        Student student2 = new Student(2, "Price", "Jonelle");
        Student student3 = new Student(3, "Jung", "Michael");
        Student student4 = new Student(4, "Klimke", "Ingrid");
        Student[] students = {student0, student1, student2, student3, student4};

        System.out.println("Setting up zad1...");
        Zad1 zad1 = new Zad1(students);
        System.out.println("\nSetting students marks...");
        zad1.setStudentMark(0, 5);
        zad1.setStudentMark(1, 2);
        zad1.setStudentMark(2, 4);
        zad1.setStudentMark(3, 3);
        System.out.println("\nShowing all students...");
        zad1.showStudents();
        System.out.println("\nShowing average positive mark...");
        zad1.avgPositiveMark();
        System.out.println("\nShowing students which haven't passed...");
        zad1.showNotPassedStudents();

        StudentZad2 studentZad20 = new StudentZad2(0, "Todd", "Mark");
        StudentZad2 studentZad21 = new StudentZad2(1, "Price", "Tim");
        StudentZad2 studentZad22 = new StudentZad2(2, "Price", "Jonelle");
        StudentZad2 studentZad23 = new StudentZad2(3, "Jung", "Michael");
        StudentZad2 studentZad24 = new StudentZad2(4, "Klimke", "Ingrid");
        StudentZad2[] studentZad2 = {studentZad20, studentZad21, studentZad22, studentZad23, studentZad24};

        studentZad20.setMarks(new ArrayList<>(Arrays.asList(4.5, 3.5 , 5.0)));
        studentZad21.setMarks(new ArrayList<>(Arrays.asList(4.0, 3.0)));
        studentZad22.setMarks(new ArrayList<>(Arrays.asList(5.5, 3.0, 1.0, 2.0, 0.5)));

        System.out.println("\nSetting up zad2...");
        Zad2 zad2 = new Zad2(studentZad2);
        System.out.println("\nAdding mark to student...");
        zad2.addStudentMark(3, 2.5);
        System.out.println("\nAll Students:");
        zad2.showStudents();
        System.out.println("\nShowing average positive mark...");
        zad2.avgPositiveMark();
        System.out.println("\nShowing Students that haven't passed...");
        zad2.showNotPassedStudents();

        System.out.println("\nSetting up zad3...");
        Zad3 zad3 = new Zad3();
        ArrayIterator<Student> studentIterator = new ArrayIterator<>(students);
        System.out.println("Moving to index 1...");
        while(studentIterator.hasNext()) {
            Student student = studentIterator.next();
            System.out.println(student);
            if(student.getIndex() == 1) {
                break;
            }
        }
//        System.out.println("Adding Student...");
//        ArrayIterator<Student> studentIteratorAdded = zad3.addStudent(studentIterator, new Student(5, "Grzyb", "Mirek"));
//        while(studentIteratorAdded.hasNext()) {
//            System.out.println(studentIteratorAdded.next());
//        }
//        System.out.println("Removing student...");
//        ArrayIterator<Student> studentIteratorRemoved = zad3.removeStudent(studentIterator, student2);
//        while(studentIteratorRemoved.hasNext()) {
//            System.out.println(studentIteratorRemoved.next());
//        }
        System.out.println("Sorting students by mark...");
        ArrayIterator<Student> studentIteratorSorted = zad3.sortMarksDescending(studentIterator);
        while (studentIteratorSorted.hasNext()) {
            System.out.println(studentIteratorSorted.next());
        }
    }
}
