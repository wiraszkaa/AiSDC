package L1;

import java.util.ArrayList;

public class StudentZad2 {
    private final int index;
    private final String surname;
    private final String name;
    private ArrayList<Double> marks;

    public StudentZad2(int index, String surname, String name) {
        this.index = index;
        this.surname = surname;
        this.name = name;
        this.marks = new ArrayList<>();
    }

    public int getIndex() {
        return index;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Double> marks) {
        this.marks = marks;
    }

    public void addMark(double mark) {
        marks.add(mark);
    }

    public double getAverageMark() {
        if (marks.size() == 0) {
            return 0;
        } else {
            return marks.stream().mapToDouble(val -> val).sum() / marks.size();
        }
    }

    @Override
    public String toString() {
        StringBuilder marksString = new StringBuilder();
        marks.forEach((val) -> marksString.append(val).append(", "));
        return getName() + " " + getSurname() + " " + getIndex() + ":\n" + "Marks: " + marksString + " Avg: " + getAverageMark();
    }
}
