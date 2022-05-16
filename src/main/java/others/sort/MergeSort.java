package others.sort;

public class MergeSort {

    public void printArr(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public void merge(int[] leftArr, int[] rightArr, int[] arr, int leftSize, int rightSize) {
        int i = 0, l = 0, r = 0;
        // The while loops checks the conditions for merging
        while (l < leftSize && r < rightSize) {
            if (leftArr[l] < rightArr[r]) {
                arr[i++] = leftArr[l++];
            } else {
                arr[i++] = rightArr[r++];
            }
        }
        while (l < leftSize) {
            arr[i++] = leftArr[l++];
        }
        while (r < rightSize) {
            arr[i++] = rightArr[r++];
        }
    }

    public void mergeSort(int[] arr, int len) {
        if (len < 2) {
            return;
        }
        int mid = len / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[len - mid];

        // Dividing array into two and copying into 2 separate arrays
        int k = 0;
        for (int i = 0; i < len; ++i) {
            if (i < mid) {
                leftArr[i] = arr[i];
            } else {
                rightArr[k] = arr[i];
                k = k + 1;
            }
        }
        // recursively calling the function to divide the sub-arrays further
        mergeSort(leftArr, mid);
        mergeSort(rightArr, len - mid);

        // Calling the merge method on each sub-division
        merge(leftArr, rightArr, arr, mid, (len - mid) );
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] array = {12, 1, 10, 50, 5, 15, 45};
        int[] arr2 = new int[]{5, 1, 10, 2, 9};
        ms.printArr(array);
        ms.printArr(arr2);
        ms.mergeSort(array, array.length);
        ms.mergeSort(arr2, arr2.length);
        System.out.println("-----APPLYING MERGE SORT-------");
        ms.printArr(array);
        ms.printArr(arr2);
    }
}
