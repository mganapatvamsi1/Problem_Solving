package others.sort;

// Insertion sort runs (time complexity) with a best case of O(N) and worst and average case of O(Nˆ2)
// Insertion sort is a stable sort with a space complexity O(1)
public class InsertionSort {

    public void printArr(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) { // unsorted part
            int temp = arr[i];
            int j = i - 1; // sorted part
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j]; // shifting larger elements to temp by 1 position
                j = j - 1;
            }
            arr[j + 1] = temp;
        }

    }

    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int[] arr = new int[] {5, 1, 2, 9, 10};
        is.printArr(arr);
        is.insertionSort(arr);
        System.out.println("-----APPLYING INSERTION SORT-------");
        is.printArr(arr);
    }
}
