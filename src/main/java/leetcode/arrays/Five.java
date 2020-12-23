package leetcode.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
//Single Number
  Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?

 */
public class Five {
    public int singleNumber(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                set.remove(arr[i]);
            } else {
                set.add(arr[i]);
            }
            if (arr.length == 1) {
                System.out.println(arr[0]);
                return arr[0];
            }
            if (arr == null) {
                return 0;
            }
        }
//        System.out.println(set.toArray()[0]);
//        return (int) set.toArray()[0];
        for (int i: set) {
            return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        Five five = new Five();
        int[] test = {2, 2, 1};
        int[] test1 = {4, 1, 2, 1, 2};
        int[] test2 = {1};
        int[] test3 = {1, 2, 1, 3, 2};

//        five.singleNumber(test);
//        five.singleNumber(test1);
//        five.singleNumber(test2);
        five.singleNumber(test3);

    }

}
