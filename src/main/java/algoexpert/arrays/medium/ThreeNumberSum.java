package algoexpert.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public static void  printArr(int[] arr) {
        for (int element: arr) {
            System.out.print(element+" ");
        }
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> triplets = new ArrayList<Integer[]>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];
                if (currentSum == targetSum) {
                    Integer[] newTriplet = {array[i], array[left], array[right]};
                    triplets.add(newTriplet);
                    left++;
                    right--;
                }
                else if (currentSum < targetSum) left++;
                else if (currentSum > targetSum) right--;
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        int[] testArr = {12, 3, 1, 2, -6, 5, -8, 6};
        int targetSum = 0;
        System.out.print("input arr: ");
        printArr(testArr);
        System.out.println();
        System.out.print("three num sum output: "+threeNumberSum(testArr, targetSum));
    }
}
