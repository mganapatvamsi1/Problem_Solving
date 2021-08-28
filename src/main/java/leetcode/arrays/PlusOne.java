package leetcode.arrays;

/*
// Plus One
Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
You may assume the integer does not contain any leading zero, except the number 0 itself.
 */
public class PlusOne {

    //TODO:: this approach is wrong: as when there are more 9's then we can't cover that result {1, 0}:: {1,0,0}
//    public int[] plusOne(int[] digits) {
//        if (digits == null || digits.length == 0) {
//            return null;
//        }
//        int[] result = new int[2];
//        if (digits.length == 1 && digits[0] == 9) {
//            result[0] = 1;
//            result[1] = 0;
//            return result;
//        } else {
//            digits[digits.length -1] += 1;
//        }
//        System.out.println("printing result: "+result);
//        System.out.println("printing the arr: "+digits);
//        return digits;
//
//    }

    //TODO: Right approach
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public int[] testingA(int[] arr) {
        int[] newOne = new int[arr.length + 1];
        int[] temp = arr;
        newOne = arr;
        arr = temp;
        return newOne;
    }


    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] testArr = {1, 2, 3};
        int[] testArr2 = {9};
        int[] testArr3 = {9, 9};
        int[] testArr4 = {9, 8, 9};
        plusOne.plusOne(testArr4);
//        eight.plusOne(testArr3);
//        eight.plusOne(testArr2);
//        eight.testingA(testArr2);
    }
}
