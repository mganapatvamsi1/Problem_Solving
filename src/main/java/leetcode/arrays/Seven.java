package leetcode.arrays;

import java.util.*;

// Intersection of Two Arrays II
// Given two arrays, write a function to compute their intersection.
// Each element in the result should appear as many times as it shows in both arrays.
public class Seven {

    //TODO: Approach-1
    // To have hashmap: key should be the element (value) and value should be the frequency
    // i.e., how many times the element appears in the array (frequency)
    // we use the 1st hashmap and traverse through the 2nd array to see how many times
    // this element has appeared in the second array, and then we can add that into a list
    // and then return that list as an array.

    // Time complexity O(m + n)
    // Space complexity O(min(m,n))
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                list.add(num);
                map.put(num, count - 1);
            }
        }
        int index = 0;
        int[] result = new int[list.size()];
        for (int num : list) {
            result[index++] = num;
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
