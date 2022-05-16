package educative.arrays;

import org.springframework.http.HttpMethod;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Arrays1 {

    public static void printArr(int[] arr) {
        for (int el : arr) System.out.print(el + " ");
        System.out.println();
    }

    //Time Complexity: Since the entire arr has to be iterated over, Time Complexity is O(N).
    public static int[] removeEven(int[] arr) {
        int oddNumsCount = 0;

        // find the number of odd elements in the array.
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) oddNumsCount++;
        }

        // create result array with the size equal to the number of odd elements in the arr
        int[] resultArr = new int[oddNumsCount];
        int index = 0;

        // Put the odd elements from the arr into the resultArr
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                resultArr[index] = arr[i];
                index++;
            }
        }

        //returning the result
        return resultArr;
    }

    public static int[] mergeTwoSortedArr(int[] arr1, int[] arr2) {
        int index1 = 0;
        int index2 = 0;
        int resultIndex = 0;
        int[] resultArr = new int[arr1.length + arr2.length];
        while (index1 < arr1.length || index2 < arr2.length) {
            if (index1 < arr1.length &&
                    arr1[index1] <= arr2[index2]) {
                resultArr[resultIndex] = arr1[index1];
                resultIndex++;
                index1++;
            } else {
                resultArr[resultIndex] = arr2[index2];
                resultIndex++;
                index2++;
            }
        }
        return resultArr;
    }

    public static int[] findTwoSum(int[] arr, int n) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(n - arr[i])) {
                map.put(arr[i], i);
            } else {
                result[1] = arr[i];
                result[0] = n - arr[i];
                return result;
            }
        }
        return null;
    }

    public static int[] findProduct(int[] arr) {
        int result[] = new int[arr.length];
        int value = 1;
        for (int i = 0; i < arr.length; i++) {
            value *= arr[i];
        }
        for (int j = 0; j < arr.length; j++) {
            result[j] = value / arr[j];
        }
        return result;
    }

    //Time complexity is O(N).
    public static int findMin(int[] arr) {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) minValue = arr[i];
        }
        return minValue;
    }

    //TODO: need to check why this is behaving in a way where its not picking the first inserted element
    public static int firstNonRepeatingIntegerArr1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) map.put(arr[i], i);
            else map.remove(map.get(arr[i]));
        }
//        if (map.containsValue(0))
        Map.Entry<Integer, Integer> entry = map.entrySet().iterator().next();
        return entry.getKey();
    }

    // TODO: edge case missing
    public static int firstNonRepeatingIntegerArr(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> repeatedSet = new HashSet<>();
        for (int ele : arr) {
            if (repeatedSet.contains(ele)) continue;
            if (set.contains(ele)) {
                set.remove(ele);
                repeatedSet.add(ele);
            } else set.add(ele);
        }
        for (int res : arr) {
            if (set.contains(res) && !repeatedSet.contains(res)) return res;
        }
        return -1;
    }

    public static int findSecondMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) if (arr[i] > max) max = arr[i];
        for (int j = 0; j < arr.length; j++) if (arr[j] > secondMax && arr[j] < max) secondMax = arr[j];
        return secondMax;
    }

    /* Rotate array to the right by K steps: This is similar to right rotate the array by 1 index.
     trick: 3 steps: example arr with k = 1: [1 2 3 4 5 6 7]
     Step1: reverse the whole array => [7 6 5 4 3 2 1]
     Step2: reverse the first K numbers => [7 6 5 4 3 2 1]
     Step3: reverse the remaining N - K numbers => [7 1 2 3 4 5 6] (Final Result)
    */
//    public static void rotateArr(int[] arr) {
    public static int[] rotateArr(int[] arr) { // ADDED return type just for the sake of printing the rotating arr.
        //step1: reverse arr
        reverse(arr, 0, arr.length - 1);
        // step2: reverse the first k elements (in this case its first element i.e, nothing has to be reversed)
        // step3: reverse the remaining n - k elements ()
        reverse(arr, 1, arr.length - 1);
        return arr;
    }

    public static int[] reverse(int[] arr) {
        reverse(arr, 0, arr.length - 1);
        return arr;
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    //Re-arranging positive and negative values:
//    public static void reArrangePositiveNegativeNums(int[] arr) {
    public static int[] reArrangePositiveNegativeNums1(int[] arr) {
        int j = arr.length - 1;
//       for (int i = 0; i < arr.length; i++) {
//           while (arr[i] < 0 && i < j) i++;
//           while (arr[j] > 0 && i < j) j--;
//           if (i < j) { // swap i and j
//               int temp = arr[i];
//               arr[i] = arr[j];
//               arr[j] = temp;
//           } else break;
//
//       }

        int i = 0;
        while (i <= j) {
            while (arr[i] < 0 && i < j) i++;
            while (arr[j] > 0 && i < j) j--;
            if (i < j) { // swap i and j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else break;
        }
        return arr; // here we are returning this array just for testing purpose.
    }

    public static int[] reArrangePositiveNegativeNums2(int[] arr) {
        int j = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] < 0 && i < j) i++;
            while (arr[j] > 0 && i < j) j--;
            if (i < j) { // swap i and j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else break;
        }
        return arr; // here we are returning this array just for testing purpose.
    }

    // re-arranging in place
    // Time complexity is O(N) with no extra space being used as the entire array is iterated only once.
    public static int[] reArrangePositiveNegativeNums3(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) { // If negative num found
                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j]; // Swapping with leftmost positive
                    arr[j] = temp;
                }
                j++; //  'j' keeps track of the position where the next encountered negative num should be placed.
            }
        }
        return arr; // here we are returning this array just for testing purpose.
    }

    // Creating new array (with this approach time complexity is O(N) and space complexity is O(N))
    private static void maxMin1(int[] arr) {
        int[] resultArr = new int[arr.length];
        int small = 0, large = arr.length - 1;
        boolean switchPointer = true; // flag to switch between the 2 pointers
        for (int i = 0; i < arr.length; i++) {
            if (switchPointer) resultArr[i] = arr[large--];
            else resultArr[i] = arr[small++];
            switchPointer = !switchPointer;
        }
        for (int j = 0; j < arr.length; j++) arr[j] = resultArr[j]; // copying to original array
    }

    //Using O(1) space and O(N) time (Optimal solution)
    private static void maxMin2(int[] arr) {
        int min = 0, max = arr.length - 1;
        int maxElement = arr[max] + 1; //Store any element that is greater than the max. element in the array
        for (int i = 0; i < arr.length; i++) {
            //Max elements are present at even indices
            if (i % 2 == 0) {
                arr[i] += (arr[max] % maxElement) * maxElement;
                max--;
            } else {
                arr[i] += (arr[min] % maxElement) * maxElement;
                min++;
            }
        }
        //Dividing with max element to get original values.
        for (int i = 0; i < arr.length; i++) arr[i] /= maxElement;
    }

    //Given an integer array, return the maximum subarray sum
    // Time complexity is O(N) and space complexity is O(1)
    private static int findMaxSumSubArray(int[] arr) {
        //Kadane’s Algorithm: This algorithm takes a dynamic programming approach to solve the maximum subarray sum problem.
        int currentMax = arr[0];
        int globalMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (currentMax < 0) currentMax = arr[i]; // if the element is less than 0 then it won't be a max. element,
                // so we don't need to consider that to be part of the count.
            else currentMax += arr[i];
            if (globalMax < currentMax) globalMax = currentMax;
        }
        return globalMax;
    }

    // Binary Search Impl on a sorted array
    //Problem statement: Given a sorted array of integers, return the index of the given key. Return -1 if the key is not found.
    // Time complexity is O(LogN) whereas Space complexity is O(1)
    public static int binarySearchIterative(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (arr[middle] == key) return middle;
            else if (key > arr[middle]) low = middle + 1;
            else high = middle - 1;
        }
        return -1;
    }

    // Time and space complexity are O(LogN) and O(LogN)
    public static int binarySearchRecursive(int[] arr, int key, int low, int high) {
        if (low > high) return -1;
        int mid = low + ((high - low) / 2);
        if (arr[mid] == key) return mid;
        else if (arr[mid] > key) return binarySearchRecursive(arr, key, low, mid - 1);
        else return binarySearchRecursive(arr, key, mid + 1, high);
    }
    //Note: The iterative solution has the same O(LogN) runtime complexity as the recursive solution
    // but has a better memory complexity i.e., O(1) compared to the O(N) of recursive space.

    //---------------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------------------------

    // The runtime complexity of this solution is linear i.e., O(N) as every element is pushed and popped from the deque only once in a single traversal.
    // The memory complexity of this solution is linear i.e., O(W) where W is the window size in this case.
    /*
         The algorithm uses deque datastructure to find the maximum in a window.
         A deque is a double-ended queue in which the push and pop operations work in O(1) time at both ends. It will act as a window.
         At the start of the algorithm we search for the maximum value in the first window. The first elements index is pushed to the front of the deque.
          If the element in the front is smaller than the element in the back of the queue then push the current element index and  that index becomes the new back,
          if the current element is larger than the element in the back, then keep popping elements from the back of the queue until we find an element that's greater than the current element,
          and of course once we find a greater element in the back, then we push the current element's index as the new back.
          As you can see the deque stores elements in a decreasing order i.e, the front of the deque contains the index of the maximum value in that particular window.
     */
    public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {
        ArrayDeque<Integer> result = new ArrayDeque<>(); // ArrayDeque for storing values
        Deque<Integer> list = new LinkedList<Integer>(); // creating a new linked list
        if (arr.length > 0) {
            if (arr.length < windowSize) return result; // this is invalid state
            for (int i = 0; i < windowSize; ++i) {
                // removing the last smallest element index
                while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) list.removeLast();
                list.addLast(i); // adding newly picked element index to the back of the list
            }
            for (int i = windowSize; i < arr.length; ++i) {
                result.add(arr[list.peek()]);
                // removing all elements indexes that are not in the current window
                while (!list.isEmpty() && list.peek() <= i - windowSize) list.removeFirst();
                // removing the smaller elements indexes that are not required
                while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) list.removeLast();
                // adding the newly picked element index to the back of the list
                list.addLast(i);
            }
            // adding the maximum number of the current window in the result
            result.add(arr[list.peek()]);
        }
        return result;
    }
    //Note: an alternate approach of this problem is to use heaps for searching the maximum in every window. But in that case the time complexity will rise to O(NLogN).


    public static int[] reverseArr2(int[] arr, int times) {
        //step-1: reverseArr
        reverse2(arr, 0, arr.length - 1);
        //step-2: reverse the first k elements i.e,. 6 in our case
        reverse2(arr, 0, times - 1);
        //step-3: reverse remaining n - k times
        reverse2(arr, times, arr.length - 1);
        return arr;
    }

    private static void reverse2(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    //Runtime complexity is O(LogN) and memory complexity is O(LogN)
    public static int binarySearchRotatedRecursive(int[] arr,int low, int high, int key) {
        // assuming all keys as unique
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (arr[mid] == key) return mid;
        if (arr[low] <= arr[mid] && key <= arr[mid] && key >= arr[low]) return binarySearchRotatedRecursive(arr, 0, mid - 1, key);
        else if (arr[mid] <= arr[high] && key >= arr[mid] && key <= arr[high]) return binarySearchRotatedRecursive(arr, mid + 1, high, key);
        else if (arr[high] <= arr[mid]) return binarySearchRotatedRecursive(arr, mid + 1, high, key);
        else if (arr[low] >= arr[mid]) return binarySearchRotatedRecursive(arr, low, mid - 1, key);
        return -1;
    }

    //Runtime complexity is O(Log N) and memory complexity is O(1)
    // this solution works iteratively, so the memory complexity of this algorithm comes down to O(1) even though the logic remains the same.
    public static int binarySearchRotatedIterative(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        if (start > end) return -1;
        while (start <= end) {
            int mid = start + (end - start) / 2; // to avoid overflow
            if (arr[mid] == key) return mid;
            if (arr[start] <= arr[mid] && key <= arr[mid] && key >= arr[end]) end = mid - 1;
            else if (arr[mid] <= arr[end] && key >= arr[mid] && key <= arr[end]) start = mid + 1;
            else if (arr[start] <= arr[mid] && arr[mid] <= arr[end] && key > arr[end]) start = mid + 1;
            else if (arr[end] <= arr[mid]) start = mid + 1;
            else if (arr[start] >= arr[mid]) end = mid - 1;
            else return -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        printArr(test1);
        int[] resultArr = removeEven(test1);
        System.out.print("Remove even nums(print odd nums) in the arr:  ");
        printArr(resultArr);

        int[] sortArr1 = {1, 3};
        int[] sortArr2 = {2, 4};
        int[] finalSortArr = mergeTwoSortedArr(sortArr1, sortArr2);
        System.out.print("Result of 2 sorted arrs are:  ");
        printArr(finalSortArr);

        System.out.print("Find two nums:  ");
//        int[] testTwoSum = {1, 21, 3, 14, 5, 60, 7, 6};
//        int[] resultTwoSum = findTwoSum(testTwoSum, 81);
        int[] testTwoSum = {1, 3, 5};
        int[] resultTwoSum = findTwoSum(testTwoSum, 6);
        printArr(resultTwoSum); // 1 5 (or) 5 1

        System.out.print("Arr of products1:  ");
        int[] arrsProduct1 = findProduct(testTwoSum);
        printArr(arrsProduct1);

        int[] nonRepeatingArr = {4, 4, 4, 3};
        System.out.println("First non repeating arr1:  " + firstNonRepeatingIntegerArr(nonRepeatingArr));

        int[] givenArr = {9, 2, 3, 2, 6, 6};
        int[] reversedArr = reverse(givenArr);
        System.out.print("Reversed arr1:  ");
        printArr(reversedArr); // 6 6 2 3 2 9

        int[] testA1 = {1, 21, 3, 14, 5, 60, 7, 6};
        int[] rotatedArr1 = rotateArr(testA1);
        System.out.print("Rotated arr1:  ");
        printArr(rotatedArr1); //6  1  21  3  14  5  60  7

        int[] testReArrange = {10, -1, 20, 4, 5, -9, -6};
//        int[] testReArrange = {1, 2, -2, -1};
//        int[] reArrangedArr = reArrangePositiveNegativeNums1(testReArrange);
        int[] reArrangedArr = reArrangePositiveNegativeNums3(testReArrange);
        // -1 -9 -6 4 5 10 20
        printArr(reArrangedArr); // -2 -1 1 2

        int[] testMaxMin1 = {-2, -1, 1, 2};
        System.out.print("Array before min/max1: ");
        printArr(testMaxMin1);
        maxMin1(testMaxMin1);
        System.out.print("Array after min/max1: ");
        printArr(testMaxMin1);

        int[] testMaxMin2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20};
        System.out.print("Array before min/max2: ");
        printArr(testMaxMin2);
        maxMin2(testMaxMin2);
        System.out.print("Array after min/max2: ");
        printArr(testMaxMin2);

        int[] testMaxSumSubArr1 = {1, 7, -2, -5, 10, -1};
        System.out.println("printing max sum subArr1: " + findMaxSumSubArray(testMaxSumSubArr1));

        int[] bSearch = {1, 2, 4, 7, 8, 12, 15, 19, 24, 50, 69, 80, 100};
        System.out.println("binary search Iterative: " + binarySearchIterative(bSearch, 12));
        System.out.println("binary search Recursive: " + binarySearchRecursive(bSearch, 12, 0, bSearch.length - 1));

        System.out.println("http post: " + HttpMethod.POST.name());
        System.out.println("http post return type: " + HttpMethod.POST.name().getClass().getSimpleName());

        int[] testReverse = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("testing reversing array2: ");
        int[] reversed2Arr = reverseArr2(testReverse, 2);
        printArr(reversed2Arr); // 6 7 1 2 3 4 5

    }
}
