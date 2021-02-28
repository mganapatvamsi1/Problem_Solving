package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// using sorting technique

// time complexity --> O(mlogm + nlogn)
// space complexity --> O(1)
public class Seven2 {
    public int[] intersect(int[] num1, int[] num2) {
        Arrays.sort(num1);
        Arrays.sort(num2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < num1.length && j < num2.length) {
            if (num1[i] == num2[j]) {
                list.add(num1[i]);
                i++;
                j++;
            } else if (num1[i] < num2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[list.size()];
        int index = 0;
        for (int num: list) {
            result[i++] = num;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
