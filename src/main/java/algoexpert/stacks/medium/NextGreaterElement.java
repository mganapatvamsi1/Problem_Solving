package algoexpert.stacks.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void printArr(int[] arr) {
        for (int element: arr) {
            System.out.print(element+ " ");
        }

    }

    public static int[] nextGreaterElement(int[] array) {
        int[] outputArr = new int[array.length];
        Arrays.fill(outputArr, -1);
        Stack<Integer> stack = new Stack<>();
        for (int index = 2 * array.length - 1; index >= 0; index--) {
            int circularIndex = index % array.length;

            while (stack.size() > 0) {
                if (stack.peek() <= array[circularIndex]) {
                    stack.pop();
                } else {
                    outputArr[circularIndex] = stack.peek();
                    break;
                }
            }
            stack.push(array[circularIndex]);

        }
        return outputArr;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 5, -3, -4, 6, 7, 2};
        System.out.print("input arr1: ");
        printArr(arr1);
        System.out.println("\n");
        System.out.print("nextGreater element arr1: ");
        printArr(nextGreaterElement(arr1));
        System.out.println("\n");
        System.out.println("----------------------------------------------------------");
        int[] arr2 = {10, 11, 12, 13, 14};
        System.out.print("input arr2: ");
        printArr(arr2);
        System.out.println("\n");
        System.out.print("nextGreater element arr2: ");
        printArr(nextGreaterElement(arr2));
        System.out.println("\n");
        System.out.println("----------------------------------------------------------");
    }
}
