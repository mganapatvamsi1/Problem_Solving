package algoexpert.sorting;

public class BubbleSort {

    private static int[] bubbleSort(int[] arr) {
        boolean isSorted = false;
        int lastUnsorted = arr.length - 1;
        for (int i = 0; i < lastUnsorted; i++) {
             isSorted = true;
             if (arr[i] > arr[i + 1]) {
                 //swap these 2 places
                 swap(arr, i, i + 1);
                 isSorted = false;
             }
            lastUnsorted--;
        }
        return arr;
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {-4, 5, 10, 8, -10, -6, -4, -2, -5, 3, 5, -4, -5, -1, 1, 6, -7, -6, -7, 8};
        System.out.println("sorting the given arr using bubblesort: "+bubbleSort(arr));
    }
}
