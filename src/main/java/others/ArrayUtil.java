package others;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;

public class ArrayUtil {

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int[] removeEven(int[] arr) {
        int oddElements = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddElements++;
            }
        }
        int[] oddElementsResult = new int[oddElements];
        int oddIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddElementsResult[oddIndex] = arr[i];
                oddIndex++;
                System.out.print(arr[i] + "  ");
            }
        }
        System.out.println();
        return oddElementsResult;
    }


    public int[] removeOdd(int[] arr) {
        int evenElements = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenElements++;
            }
        }

        int[] evenElementsResult = new int[evenElements];
        int evenIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenElementsResult[evenIndex] = arr[i];
                System.out.print(arr[i] + "  ");
                evenIndex++;
            }
        }
        System.out.println();
        return evenElementsResult;
    }

    public int[] resize(int[] arr, int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
//        arr = temp;
//        return arr;
        return temp;
    }

    public int findMinValue(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        int minimum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minimum) {
                minimum = arr[i];
            }
        }
        return minimum;
    }

    public int findMaxValue(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Imvalid Input");
        }
        int maximum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maximum) {
                maximum = arr[i];
            }
        }
        return maximum;
    }

    // using stack
    public int[] reverseArrUsingStack(int[] arr) {
        int[] newArray = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            int poppedValue = stack.pop();
            newArray[i] = poppedValue;
            System.out.print(newArray[i] + " ");
        }
        System.out.println();
        return newArray;
    }

    // using array
    public void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public boolean isPalindrome(String value) {
        char[] charArr = value.toCharArray();
        int start = 0;
        int end = charArr.length - 1;
        while (start < end) {
            if (charArr[start] != charArr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int secondMax(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("This should have atleast 2 elements");
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i  = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax){
                    secondMax = arr[i];
            }
            if (secondMax == Integer.MIN_VALUE) {
                throw new NoSuchElementException("Array doesn't have second max element");
            }
        }
        return secondMax;
    }
    public int secondMax1(int arr[]) {
        if (arr == null || arr.length == 0 ||
                arr.length < 2) {
            throw new IllegalArgumentException("Invalid Input");
        }
        int firstMax = 0;
        int secondMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstMax) {
                secondMax = firstMax;
                firstMax = arr[i];
            } else if (arr[i] > secondMax) {
                secondMax = arr[i];
            } else if(firstMax == secondMax) {
                throw new NoSuchElementException("There's no secondmaximum element");
            }
        }
        return secondMax;
    }

    public int secondMin(int[] arr) {
        int min = 1000;
        int secondMin = 1000;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                secondMin = min;
                min = arr[i];
            } else if (arr[i] < secondMin) {
                secondMin = arr[i];
            }
        }
        return secondMin;
    }

    // returning indices of the twoSum method
    public int[] twoSum(int[] arr, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!resultMap.containsKey(target - arr[i])) {
                resultMap.put(arr[i], i);
            } else {
                result[1] = i;
                result[0] = resultMap.get(target - arr[i]);
                return result;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        ArrayUtil arrayUtil = new ArrayUtil();
        int[] testArray = {10, 12, 13, 14, 15, 16};
        arrayUtil.removeEven(testArray);
        arrayUtil.removeOdd(testArray);

        int[] originalArray = new int[]{1, 2, 3, 4, 5};
        System.out.println("original array size: " + originalArray.length);
        int[] newResizedArray = arrayUtil.resize(originalArray, originalArray.length * 2);

        System.out.println("newResizedArray size: " + newResizedArray.length);

        System.out.println("min value in testArray is: " + arrayUtil.findMinValue(testArray));
        System.out.println("min value in originalArray is: " + arrayUtil.findMinValue(originalArray));
        System.out.println("maximum val in testArray is: " + arrayUtil.findMaxValue(testArray));
        System.out.println("maximum val in originalArray is: " + arrayUtil.findMaxValue(originalArray));

        //Reversing an array
        System.out.println("stack of stack");
        arrayUtil.printArray(testArray);
        System.out.println("reversing testArray: " + arrayUtil.reverseArrUsingStack(testArray));
        arrayUtil.printArray(originalArray);
        System.out.println("reversing originalArray: " + arrayUtil.reverseArrUsingStack(originalArray));
        System.out.println("end of stack");

        System.out.println("start of arr  reversal");
        arrayUtil.printArray(testArray);
        arrayUtil.reverseArray(testArray, 0, testArray.length - 1);
        arrayUtil.printArray(testArray);
        arrayUtil.printArray(originalArray);
        arrayUtil.reverseArray(originalArray,0,originalArray.length - 1);
        arrayUtil.printArray(originalArray);
        System.out.println();
        int[] testingOnly = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        arrayUtil.printArray(testingOnly);
        arrayUtil.reverseArray(testingOnly,0,9);
        arrayUtil.printArray(testingOnly);
        System.out.println("end of array reversal");


        // to check if a given string is a palindrome or not
        System.out.println("is madam word a palindrome: "+arrayUtil.isPalindrome("madam"));
        System.out.println("is test word a palindrome: "+arrayUtil.isPalindrome("test"));

        // finding second max element
//        System.out.println("second max in testingOnly:: "+arrayUtil.secondMax(testingOnly));
//        System.out.println("second max in testArray:: "+arrayUtil.secondMax(testArray));
//        System.out.println("second max in originalArray:: "+arrayUtil.secondMax(originalArray));

        // finding second min
        // finding second max element
//        System.out.println("second min in testingOnly:: "+arrayUtil.secondMin(testingOnly));
//        System.out.println("second min in testArray:: "+arrayUtil.secondMin(testArray));
//        System.out.println("second min in originalArray:: "+arrayUtil.secondMin(originalArray));

        int[] givenArr = {2, 9, 6, 15, 0, 2, 5};
        int[] givenArr2 = {2};
        int[] givenArr3 = {2, 2};
//        System.out.println("second max in givenArr:: "+arrayUtil.secondMax(givenArr));
//        System.out.println("second max in givenArr:: "+arrayUtil.secondMax(givenArr3));
//        System.out.println("second max in givenArr:: "+arrayUtil.secondMax(givenArr2));

        // Two sum (to return the indices)
        int[] numbers = {2, 11, 5, 10, 7, 8};
        int[] res = arrayUtil.twoSum(numbers, 9);
        int[] res1 = arrayUtil.twoSum(givenArr, 21);
        System.out.println("two sum indices are :: "+res[0] + " and " + res[1]);
        System.out.println("two sum indices are :: "+res1[0] + " and " + res1[1]);

    }

}



/*
 // find 2nd largest element

  public int secondMax(int arr[]) {
        if (arr == null || arr.length == 0 ||
        arr.length < 2) {
            throw new IllegalArgumentException("Invalid Input");
        }
		int firstMax = 0;
		int secondMax = 0;
		for (int i = 0; i < arr.length; i++) {
		    if (arr[i] > firstMax) {
		        secondMax = firstMax;
		        firstMax = arr[i];
		    } else if (arr[i] > secondMax) {
		        secondMax = arr[i];
		    }
		    if(firstMax == secondMax) {
		      throw new NoSuchElementException("There's no second maximum element");
		    }
		}
		return secondMax;
	}

	// this is giving an exception......
 */
