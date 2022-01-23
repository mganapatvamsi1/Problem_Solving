package educative.arrays;

import java.util.List;

public class Arrays2 {

    public static void printArr(int[] arr) {
        for (int el : arr) System.out.print(el + " ");
        System.out.println();
    }

    // finding the smallest common number
    // Runtime complexity is O(N) and Memory complexity is O(1)
    // Note:: to use 3 pointer approach and the fact that arrays are sorted in ascending order.
    public static int findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            // find the smallest common number
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) return arr1[i];
            // increment the iterator for the smallest value
            if (arr1[i] <= arr2[j] && arr1[i] <= arr3[k]) i++;
            else if (arr2[j] <= arr1[i] && arr2[j] <= arr3[k]) j++;
            else if (arr3[k] <= arr1[i] && arr3[k] <= arr2[j]) k++;
        }
        return -1;
    }

    // find the low/high index of a key in a Sorted Array
    // we need to do binary search twice:
    // once for finding low index and next for finding high index
    // Even though we do binary search twice, the asymptotic runtime complexity is O(LogN)
    // Since no extra memory space is used, space complexity is O(1) (Iterative)
    //Note: space complexity can get O(LogN) too if we use recursive solution
    public static int findLowIndex(List<Integer> arr, int key) {
        int low = 0;
        int high = arr.size() - 1;
        int mid = high / 2;
        while (low <= high) {
            int midElement = arr.get(mid);
            if (midElement <= key) low = mid + 1;
//            else if (midElement > key) high = mid - 1;
            else high = mid - 1;
            mid = low + (high - low) / 2;
        }
        if (low < arr.size() && arr.get(low) == key) return low;
        return -1;
    }
    public static int findHighIndex(List<Integer> arr, int key) {
        int low = 0;
        int high = arr.size() - 1;
        int mid = high  / 2;
        while (low <= high) {
            int midElement = arr.get(mid);
            if (midElement <= key) low = mid + 1;
            else high = mid - 1;
            mid = low + (high - low) / 2;
        }
        if (high == -1 || (high < arr.size() && arr.get(high) == key)) return high;
        return -1;
    }

    // the array has to be modified in-place i.e, space complexity is O(1) and time complexity is O(N)
    // we also need to maintain the order of non-zero elements in the array
    public static void moveZerosToLeft(int[] arr) {
        if (arr.length < 1) return;
        int readIndex = arr.length - 1;
        int writeIndex = arr.length - 1;
        while (readIndex >= 0) {
            if (arr[readIndex] != 0) {
                arr[writeIndex] = arr[readIndex];
                writeIndex--;
            }
            readIndex--; // this means arr[readIndex] == 0, so we have to decrement readIndex.
        }
        while (writeIndex >= 0) {
            arr[writeIndex] = 0;
            writeIndex--;
        }
        System.out.print("final arr: ");
        printArr(arr);
    }

    //Stock Buy Sell to Maximize Profit



    public static void main(String[] args) {
        int[] v1 = new int[]{6, 7, 10, 25, 30, 63, 64};
        int[] v2 = new int[]{0, 4, 5, 6, 7, 8, 50};
        int[] v3 = new int[]{1, 6, 10, 14};
        System.out.println("Least Common Number: " + findLeastCommonNumber(v1, v2, v3)); // 6

        System.out.print("initial arr: ");
        int[] moveZerosArr = new int[]{1, 10, 20, 0, 59, 63, 0, 88, 0};
        printArr(moveZerosArr);
        moveZerosToLeft(moveZerosArr);

    }
}
