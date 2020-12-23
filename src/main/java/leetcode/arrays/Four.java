package leetcode.arrays;

/*
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */

import java.util.HashSet;

public class Four {

    public boolean isDuplicate(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("array can't be null");
        }
        HashSet<Integer> hashSet = new HashSet<>();

//        for (int i = 0; i < arr.length ; i++) {
//            if (hashSet.contains(arr[i]))  {
//                return true;
//            } else {
//                hashSet.add(arr[i]);
//            }
//        }

        for (int i : arr) {
            if (hashSet.contains(arr[i])) {
                return true;
            } else {
                hashSet.add(arr[i]);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Four four = new Four();
        int[] test = {1, 2, 3, 1};
        int[] test1 = {2, 14, 18, 22, 22};
        int[] test2 = {3, 1};
//        System.out.println("is duplicate: "+four.isDuplicate(test2));
//        System.out.println("is duplicate: "+four.isDuplicate(test1));
        System.out.println("is duplicate: "+four.isDuplicate(test));
    }
}

/*
//TODO: this sol is not working
public boolean containsDuplicate(int[] nums) {
        if (nums == null ||  nums.length == 0) {
            return false;
        }

        int first = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            if (i != nums.length && nums[i] == first) {
                return true;
            }
            if (i != nums.length - 1 && nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
 */