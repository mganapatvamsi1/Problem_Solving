package leetcode.arrays;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?

 */
public class RotateTheArrayToTheRight {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0 , nums.length - 1); // reverse the whole array
        reverse(nums, 0 , k - 1); // reverse first k numbers
        reverse(nums, k, nums.length - 1); // remaining (n-k) numbers
    }

    public void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public void test(int[] prac) {
        for (int i = 0; i < prac.length; i++) {
            System.out.println("before "+prac[prac.length - 1]);
            System.out.println("before "+prac[0]);
            prac[prac.length - 1] = prac[0];
            System.out.println("after "+prac[prac.length - 1]);
            System.out.println("after "+prac[0]);
        }
    }


    public static void main(String[] args) {
        RotateTheArrayToTheRight rotateTheArrayToTheRight = new RotateTheArrayToTheRight();
        int[] test1 = {1, 2, 3, 4, 5, 6, 7};
        rotateTheArrayToTheRight.rotate(test1, 3);

//        three.test(test1);
    }
}
