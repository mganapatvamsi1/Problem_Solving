package others.sort;

public class QuickSort {

    public void printArr(int[] arr) {
        for (int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /*
    This function takes last element as the pivot, places the pivot element at its correct position in sorted array,
    and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot.
    */
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of the smaller element
        for (int j = low; j < high; j++) {
            // if current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j] //TODO:: didn't understand on what this swap is doing as both i and j should be same
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i + 1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public void quickSort(int[] arr, int low, int high) {
        if (arr.length < 2) {
            return;
        }
        if (low < high) {
            // "pi" is partitioning index, making sure that pi" is at right place
            int pi = partition(arr, low, high);

            // recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] array = {12, 1, 10, 50, 5, 15, 45};
        int[] arr2 = new int[]{5, 1, 10, 2, 9};
        qs.printArr(array);
        qs.printArr(arr2);
        qs.quickSort(array, 0, array.length - 1);
        qs.quickSort(arr2, 0, arr2.length - 1);
        System.out.println("-----APPLYING QUICKSORT-------");
        qs.printArr(array);
        qs.printArr(arr2);
    }
}
