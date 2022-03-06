package L1;

public class Student {
    private final int index;
    private final String surname;
    private final String name;
    private double mark = -1;

    public Student(int index, String surname, String name) {
        this.index = index;
        this.surname = surname;
        this.name = name;
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

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        String mark = "" + getMark();
        if(getMark() == -1) {
            mark = "none";
        }
        return getName() + " " + getSurname() + " " + getIndex() + ":\n" + "Mark: " + mark;
    }
}
