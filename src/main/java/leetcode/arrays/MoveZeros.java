package leetcode.arrays;

/*
Move Zeros
Given an array nums, write a function to move all 0's to the end
of it while maintaining the relative order of the non-zero elements.
Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */

public class MoveZeros {

    public void moveZeros(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        int[] test1 = {0,1,0,3,12};
        int[] test2 = {0,1};
        moveZeros.moveZeros(test1);
//        nine.moveZeros(test2);
    }
}
