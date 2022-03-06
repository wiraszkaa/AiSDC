package L01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Pascal Triangle
        int depth = 4;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        List<Integer> buffer = list;
        System.out.println(1);
        for (int i = 0; i < depth; i++) {
            buffer = nextPascalLine(buffer);
            buffer.forEach((integer) -> System.out.print(integer + " "));
            System.out.println();
        }
    }

    public static List<Integer> nextPascalLine(List<Integer> pascalLine) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(pascalLine.get(0));
        for (int i = 0; i < pascalLine.size() - 1; i++) {
            result.add(pascalLine.get(i) + pascalLine.get(i + 1));
        }
        result.add(pascalLine.get(pascalLine.size() - 1));
        return result;
    }
}
