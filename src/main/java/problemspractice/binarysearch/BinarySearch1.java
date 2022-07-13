package problemspractice.binarysearch;

public class BinarySearch1 {

    private static int binarySearchAscendingOrder(int[] arr, int target) {
       int low = 0;
       int high = arr.length - 1;
       while (low <= high) {
//           int mid = (low + high) / 2;
           //IMP: (low + high) value for large might end up exceeding the range of integers we've in java (overflow).
           int mid = low + (high - low) / 2;
           if (arr[mid] > target) high = mid - 1;
           else if (arr[mid] < target) low = mid + 1;
           else return mid;
       }
        return Integer.MIN_VALUE;
    }

    private static int binarySearchDescendingOrder(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) start = mid + 1;
            else if (arr[mid] < target) end = mid - 1;
            else return mid;
        }
        return Integer.MIN_VALUE;
    }

    /**
     * when we don't know if the given array is sorted in ascending or descending order then
     * how do we apply binarySearch on it.
     */
    private static int orderAgnosticBinarySearch(int[] arr, int target) {
        // if start > end in the array then its ascending order array, otherwise its descending order array.
        if (arr[arr.length - 1] > arr[0]) return binarySearchAscendingOrder(arr, target);
        else return binarySearchDescendingOrder(arr, target);
    }

    private static int orderAgnosticBinarySearch2(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean isAscending = arr[start] < arr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            if (isAscending) {
                if (arr[mid] > target) end = mid - 1;
                else start = mid + 1;
            } else {
                if (arr[mid] < target) end = mid - 1;
                else start = mid + 1;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] testArr2 = {1, 2, 3, 4, 5};
        int[] testArr = {10, -9, -6, -1, 1, 3, 4, 5, 6,7, 10, 14, 21, 60};
        int[] testArrDescending1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        int[] testArr = {10, 1, 3, 4, 5, 6,7, 10, 14, 21, 60};
        System.out.println("index of searched element using BSearch: " + orderAgnosticBinarySearch2(testArr2, 3)); // 2
        System.out.println("index of searched element using BSearch: " + orderAgnosticBinarySearch2(testArr, 60)); // 13
        System.out.println("index of searched element using BSearch: " + orderAgnosticBinarySearch2(testArr, 70)); // Integer.MIN_VALUE i.e, -2147483648
        System.out.println("index of descending element 5: " + orderAgnosticBinarySearch2(testArrDescending1, 5)); // 5

    }
}
