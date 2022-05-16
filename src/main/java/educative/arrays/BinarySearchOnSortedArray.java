package educative.arrays;

/*
 *
 * Binary Search Impl on a sorted array
 * Problem statement: Given a sorted array of integers, return the index of the given key. Return -1 if the key is not found.
 *
 */

public class BinarySearchOnSortedArray {

    // Iterative:::
    // Time complexity is O(LogN)
    //Space complexity is O(1)
    public static int binarySearchIterative(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = low + ((high - low) / 2);
        while (low <= high) {
            if (nums[mid] > target) high = mid - 1;
            else if (nums[mid] < target) low = mid + 1;
            else return mid; // nums[mid] == target
        }
        return -1;
    }


    //Recursive:::
    // Time complexity is O(LogN)
    //Space complexity is O(LogN)
    public static int binarySearchRecursive(int[] nums, int target, int low, int high) {
        if (low > high) return -1;
        int mid = low + ((high - low) / 2);
        if (nums[mid] > target) return binarySearchRecursive(nums, target, low, mid - 1);
        else if (nums[mid] < target) return binarySearchRecursive(nums, target, mid + 1, high);
        else return mid;// nums[mid] == target
    }

    public static void main(String[] args) {

    }
}
