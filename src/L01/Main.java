package L01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoAnswerException {
        //Pascal Triangle
//        int depth = 4;
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        List<Integer> buffer = list;
//        System.out.println(1);
//        for (int i = 0; i < depth; i++) {
//            buffer = nextPascalLine(buffer);
//            buffer.forEach((integer) -> System.out.print(integer + " "));
//            System.out.println();
//        }
        //SecondSmallest
//        System.out.println(getSecondSmallest(new int[]{-2, -2}));
        //NextPermutation
        int[] permutation = new int[]{1, 2, 3};
        boolean quit = false;
        while(!quit) {
            if(nextPermutation(permutation)) {
                for (int i : permutation) {
                    System.out.print(i + " ");
                }
            }
            if ("q".equals(new Scanner(System.in).nextLine())) {
                quit = true;
            }
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

    public static int getSecondSmallest(int[] array) throws NoAnswerException {
        int smallest = array[0];
        int secondSmallest = array[0];
        for (int i: array) {
            if (i < secondSmallest) {
                secondSmallest = i;
            }
            if(i < smallest) {
                secondSmallest = smallest;
                smallest = i;
            }
            if(secondSmallest == smallest && i > secondSmallest) {
                secondSmallest = i;
            }
        }
        if(secondSmallest == smallest || array.length < 2) {
            throw new NoAnswerException("Brak odpowiedzi", new Error());
        }
        return secondSmallest;
    }

    public static boolean nextPermutation(int[] array) {
        int len = array.length;
        int i = len - 2;
        while (i >= 0 && array[i] >= array[i + 1]) {
            i--;
        }
        if(i < 0) {
            return false;
        } else {
            int index = binarySearch(array, i + 1, len - 1, array[i]);
            swap(array, i, index);
            reverse(array, i + 1, len - 1);
            return true;
        }
    }

    private static int binarySearch(int[] array, int start, int end, int value) {
        int index = -1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(array[mid] <= value) {
                end = mid - 1;
            } else {
                start = mid + 1;
                if (index == -1 || array[index] >= array[mid]) {
                    index = mid;
                }
            }
        }
        return index;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void reverse(int[] array, int start, int end) {
        while(start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }
}
