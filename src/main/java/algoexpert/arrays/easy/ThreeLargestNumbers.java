package algoexpert.arrays.easy;

public class ThreeLargestNumbers {

    public static void printElements(int[] arr) {
//        for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + "  ");
        for (int element: arr) System.out.print(element + "  ");
        System.out.println();
    }

    public static int[] threeLargestNumbers(int[] arr) {
        if (arr == null || arr.length < 3) throw new IllegalArgumentException("arr should have atleast 3 elements.");
        int[] resultArr = new int[3];
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = arr[i];
            } else if (arr[i] > secondMax) {
                thirdMax = secondMax;
                secondMax = arr[i];
            } else if (arr[i] > thirdMax) thirdMax = arr[i];
        }

        resultArr[0] = thirdMax;
        resultArr[1] = secondMax;
        resultArr[2] = firstMax;
        return resultArr;
    }

    public static void main(String[] args) {
        int[] test1 = {10, 5, 9, 10, 12};
        int[] test2 = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        int[] test3 = {7, 8, 55};
        int[] test4 = {7, 7, 7};
        int[] test5 = {7, 7, 8};
        System.out.print("test1: ");
        printElements(threeLargestNumbers(test1));
        System.out.print("test2: ");
        printElements(threeLargestNumbers(test2));
        System.out.print("test3: ");
        printElements(threeLargestNumbers(test3));
        System.out.print("test4: ");
        printElements(threeLargestNumbers(test4));
        System.out.print("test5: ");
        printElements(threeLargestNumbers(test5));
    }
}
