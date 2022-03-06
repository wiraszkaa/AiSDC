package L1;

public class Zad1 {
    private final Student[] students;
    private final StudentIterator studentIterator;

    public Zad1(Student[] students) {
        this.students = students;
        this.studentIterator = new StudentIterator(students);
    }

    public void showStudents() {
        studentIterator.reset();
        while(studentIterator.hasNext()) {
            System.out.println(studentIterator.next());
        }
    }

    public void setStudentMark(int index, double mark) {
        studentIterator.reset();
        while(studentIterator.hasNext()) {
            if(studentIterator.next().getIndex() == index) {
                studentIterator.setMark(mark);
            }
        }
    }

    public void avgPositiveMark() {
        studentIterator.reset();
        double markSum = 0;
        double studentNum = 0;
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            if(student.getMark() >= 3) {
                markSum += student.getMark();
                studentNum++;
            }
        }
        System.out.println("Average Positive Mark= " + markSum/studentNum);
    }

    public void showNotPassedStudents() {
        studentIterator.reset();
        while(studentIterator.hasNext()) {
            Student student = studentIterator.next();
            if(student.getMark() < 3) {
                System.out.println(student);
            }
        }
    }
}
