package algoexpert.arrays;

import java.util.List;

public class Test1 {

    public void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i]+ "  ");
        System.out.println();
    }

    public int[] removeOddNos(int[] arr) {
        int evenNos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) evenNos++;
        }
        int[] resultArr = new int[evenNos];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                resultArr[index] = arr[i];
                index++;
            }
        }
        return resultArr;
    }

    public int findSecondMax(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length < 2) throw new IllegalArgumentException("Invalid Input");
        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) if (arr[i] > max) max = arr[i];
        for (int i = 0; i < arr.length; i++) if (arr[i] < max && arr[i] > secondMax) secondMax = arr[i];
        return secondMax;
    }

    // TIme complexity is O(N) and space complexity is O(1) where N is the length of the array.
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int arrayIndex = 0;
        int sequenceIndex = 0;
        while (arrayIndex < array.size() && sequenceIndex < sequence.size()) {
            if (array.get(arrayIndex).equals(sequence.get(sequenceIndex))) sequenceIndex++;
            arrayIndex++;
        }
        return sequenceIndex == sequence.size();
    }

    // Time complexity is O(N) and space complexity is O(1).
    public static boolean isValidSubsequence2(List<Integer> array, List<Integer> sequence) {
        int sequenceIndex = 0;
        for (int value: array) {
            if (sequenceIndex == sequence.size()) break;
            if (sequence.get(sequenceIndex).equals(value)) sequenceIndex++;
        }
        return sequenceIndex == sequence.size();
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
//        int[] arr1 = {5, 10, 15, 20, 25};
//        test1.printArr(arr1);
        int[] remove = {1, 2, 3, 4, 5, 6};
        int[] evenNosArr = test1.removeOddNos(remove);
        test1.printArr(evenNosArr);


    }
}
