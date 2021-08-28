package leetcode.arrays;

import java.util.HashSet;

/*
// Intersection of Two Arrays II
Given two arrays, write a function to compute their intersection.
// each element in the result set is unique
 */
public class IntersectionOfTwoArrays2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int i: nums1) {
            set1.add(i);
        }
        HashSet<Integer> intersection = new HashSet<>();
        for (int j : nums2) {
            if (set1.contains(j)) {
                intersection.add(j);
            }
        }
        int[] result = new int[intersection.size()];
        int index = 0;
        for (int k : intersection) {
            result[index++] = k;
        }
        return result;
    }


    public static void main(String[] args) {

    }
}


/*
public int[] intersect(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int i: nums1) {
            set1.add(i);
        }
        HashSet<Integer> intersection = new HashSet<>();
        for (int j : nums2) {
            if (set1.contains(j)) {
                intersection.add(j);
            }
        }
        int[] result = new int[intersection.size()];
        int index = 0;
        for (int k : intersection) {
            result[index++] = k;
        }
        return result;
    }
     input: [1,2,2,1] [2,2]
    output: [2]
    expected: [2,2] (41/61 passed)




    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> set1 = new ArrayList<>();
        for (int i: nums1) {
            set1.add(i);
        }
        List<Integer> intersection = new ArrayList<>();
        for (int j : nums2) {
            if (set1.contains(j)) {
                intersection.add(j);
            }
        }
        int[] result = new int[intersection.size()];
        int index = 0;
        for (int k : intersection) {
            result[index++] = k;
        }
        return result;
    }

    input: [4,9,5] [9,4,9,8,4]
    output: [9,4,9,4]
    expected: [4,9] (27/61 passed)
 */