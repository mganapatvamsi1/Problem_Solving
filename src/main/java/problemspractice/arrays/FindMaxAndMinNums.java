package problemspractice.arrays;

import java.util.Arrays;

public class FindMaxAndMinNums {

    private static int findMax(int[] arr) {
//        int max = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] > max) {
//                max = arr[i];
//            }
//        }
        int max = Integer.MIN_VALUE;
        for (int element : arr) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
//        int min = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] < min) {
//                min = arr[i];
//            }
//        }
        int min = Integer.MAX_VALUE;
        for (int element : arr) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }

    private static int[] search2DArr(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) return new int[]{row, col};
            }
        }
        return new int[]{-1, -1};
    }

    private static int maxElementIn2DArrUsingTraditionalForLoop(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] > max) max = arr[row][col];
            }
        }
        return max;
    }

    private static int maxElementIn2DArr(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int[] ints : arr) {
            for (int element : ints) {
                if (element > max) max = element;
            }
        }
        return max;
    }

    private static int minElementIn2DArr(int[][] arr) {
        int min = Integer.MAX_VALUE;
        for (int[] ints : arr) {
            for (int element : ints) {
                if (element < min) min = element;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] testArr = {2, 3, 1, 4, 5, 10, 11, 12, 6, 7, 8, 9, 19};
        int[][] test2DArr = {
                {2, 3, 1, 4, 5},
                {10, 11, 12, 6},
                {7, 8, 9, 19},
                {26, 81, 94, 8},
                {-11}
        };
        int[][] test2DArr2 = {
                {2},
                {10},
                {7, 8},
                {26, 81},
                {7, -1}
        };
        System.out.println("Maximum no. is: " + findMax(testArr)); //Maximum no. is: 19
        System.out.println("Minimum no. is: " + findMin(testArr)); //Minimum no. is: 1
        int[] solution2 = search2DArr(test2DArr2, 81);
        System.out.println("arr matching: " + Arrays.toString(solution2)); // [3, 1]
        int[] solution = search2DArr(test2DArr, 94); // [3, 2]
        System.out.println("arr matching: " + Arrays.toString(solution));
        int maxElement1 = maxElementIn2DArr(test2DArr);
        int maxElement1a = maxElementIn2DArrUsingTraditionalForLoop(test2DArr);
        int maxElement2 = maxElementIn2DArr(test2DArr2);
        System.out.println("max element1: " + maxElement1);
        System.out.println("max element1a: " + maxElement1a);
        System.out.println("max element2: " + maxElement2);
        int minElement1 = minElementIn2DArr(test2DArr);
        int minElement2 = minElementIn2DArr(test2DArr2);
        System.out.println("min element1: " + minElement1);
        System.out.println("min element2: " + minElement2);


    }
}
