package algoexpert.arrays.easy;

public class SortedSquaredArr {

    public void printArr(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    // Time complexity is O(N) | Space complexity is O(N)
    // where N is the length of the input array.
    public int[] sortedSquaredArray(int[] array) {
        int[] resultArr = new int[array.length];
        int smallerIndex = 0;
        int largerIndex = array.length - 1;
        for (int i = array.length -1; i >= 0; i--) {
            int smallerValue = array[smallerIndex];
            int largerValue = array[largerIndex];
            if (Math.abs(smallerValue) > Math.abs(largerValue)) {
                resultArr[i] = smallerValue * smallerValue;
                smallerIndex++;
            } else {
                resultArr[i] = largerValue * largerValue;
                largerIndex--;
            }
        }
        return resultArr;
    }

    public static void main(String[] args) {
        SortedSquaredArr sortedSquaredArr = new SortedSquaredArr();
        int[] test1 = {1, 2};
       int[] result = sortedSquaredArr.sortedSquaredArray(test1);
       sortedSquaredArr.printArr(result);


    }
}
