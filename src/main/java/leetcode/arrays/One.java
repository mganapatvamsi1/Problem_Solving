package leetcode.arrays;

import javax.naming.PartialResultException;
import java.util.HashMap;
import java.util.Map;

/*
   // Remove duplicates from sorted array
   Given a sorted array nums, remove the duplicates in-place such that each element
    appears only once and returns the new length.
   Do not allocate extra space for another array, you must do this by
   modifying the input array in-place with O(1) extra memory.
*/
public class One {

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public int removeDuplicates(int[] nums) {
        int index = 1;
        System.out.println("before length: "+nums.length);
        for (int i = 0 ; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[index++] = nums[i + 1];
            }
        }
        System.out.println("length after removing duplicates is: "+index);
        return index;
    }

    public static void main(String[] args) {
        One one  = new One();
        int[] testArr = {1, 1, 2, 3, 3, 4, 4};
        one.printArray(testArr);
        one.removeDuplicates(testArr);
        one.printArray(testArr);
    }

}
