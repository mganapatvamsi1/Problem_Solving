package others.sort;

import java.util.stream.IntStream;

public class SelectionSort {

    public void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] > arr[min]) { // for descending order
                if (arr[j] < arr[min]) { // for ascending order
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int[] arr = new int[]{3, 1, 5, 2, 6};
        int[] arr2 = new int[]{5, 1, 10, 2, 9};
        ss.printArr(arr);
        ss.printArr(arr2);
        ss.selectionSort(arr);
        ss.selectionSort(arr2);
        System.out.println("-----APPLYING SELECTION SORT-------");
        ss.printArr(arr);
        ss.printArr(arr2);
//        int[] arr = new int[] {3, 1, 5, 2, 6};
//        int arrayMinJava8Min = IntStream.of(arr).min().getAsInt();
//        int arrayMinJava8Max = IntStream.of(arr).max().getAsInt();
//        int arrMinJava7 = arr[0];
//        for (int i : arr) {
//            arrMinJava7 = Math.min(arrMinJava7, i);
//        }
//        System.out.println("java8 min:: "+arrayMinJava8Min);
//        System.out.println("java8 max:: "+arrayMinJava8Max);
//        System.out.println("java7 min:: "+arrMinJava7);
    }
}
