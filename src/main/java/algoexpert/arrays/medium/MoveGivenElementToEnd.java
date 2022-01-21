package algoexpert.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveGivenElementToEnd {
   // Time complexity is O(N) and space complexity is O(1)
    // where N is the length of the given list.
    public static List<Integer> moveGivenElementToEnd(List<Integer> list, int elementToMove) {
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            while (start < end && list.get(end) == elementToMove) end--;
            if (list.get(start) == elementToMove) swap(list, start, end);
            start++;
        }
        return list;
    }

    private static void swap(List<Integer> list, int start, int end) {
        int temp = list.get(end);
        list.set(end, list.get(start));
        list.set(start, temp);
    }

    public static void main(String[] args) {
        List<Integer> test1 = new ArrayList<>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));  // "toMove": 2
        List<Integer> test2 = Arrays.asList(1, 2, 4, 5, 6); //  "toMove": 3

        System.out.println("first example: "+moveGivenElementToEnd(test1, 2));
        System.out.println("-------------------------");
        System.out.println("second example: "+moveGivenElementToEnd(test2, 3));
    }
}
