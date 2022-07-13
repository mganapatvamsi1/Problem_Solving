package problemspractice.linearsearch;

public class LSearch1 {
    // In both of these best case time-complexity is O(1) and worst case time-complexity is O(N).
    // If search in the array return index if item found, otherwise return -1 if item not found.
    private static int linearSearch1(int[] arr, int key) {
        if (arr.length == 0)  return -1;
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == key) return index;
        }
        return -1;
    }

    // search for the target and return the element itself
    private static int linearSearch2(int[] arr, int key) {
        if (arr.length == 0) return -1;
        // traditional for loop
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == key) return key;
//        }
        // replacing traditional loop with enhanced for loop
        for (int element: arr) {
            if (element == key) return element; // return key;
        }
        return -1;
    }

    // if element found the return true otherwise return false
    private static boolean linearSearch3(int[] arr, int key) {
        if (arr.length == 0)  return false;
        for (int element: arr) {
            if (element == key) return true;
        }
        return false;
    }

    // searching for an exact character in a given string
    private static boolean searchCharInStr(String givenStr, char target) {
        if (givenStr.length() == 0) return false;
        // traditional for loop
//        for (int i = 0; i < givenStr.length(); i++) {
//            if (Character.toLowerCase(givenStr.charAt(i)) == target) return true;
//        }
        // enhanced for loop
        for (char character: givenStr.toCharArray()) {
            if (Character.toLowerCase(character) == target) return true;
        }
        return false;
    }

    // Similar to the initial linearSearch problem with the only difference that here we're checking in a range
    private static int searchInRange(int[] arr, int target, int start, int end) {
//        if (arr.length == 0) return -1;
        if (arr.length == 0) return Integer.MAX_VALUE;
        for (int index = start; index <= end; index++) {
            if (arr[index] == target) return index;
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 43, 7, 8, 9, 10};
        System.out.println("index of the given value: " + linearSearch1(arr, 43));
        System.out.println("value with key match: " + linearSearch2(arr, 43));
        System.out.println("boolean key match: " + linearSearch3(arr, 433));
        System.out.println("character found or not: " + searchCharInStr("ManikantaG", 'p'));
        System.out.println("character found or not: " + searchCharInStr("ManikantaG", 'g'));
        System.out.println("index for a search range: " + searchInRange(arr, 5, 1, 4));
    }
}
