package others.stacks;

import java.util.Stack;

/*
Reversing a string
Time Complexity of reverse method is O(N)
Space Complexity of reverse method is O(N)
 */
public class ReverseStr {

    public String reverseString1(String s) {
        Stack<Character> stack = new Stack<>();
        char[] initialChars = s.toCharArray();
        for (char c : initialChars) {
            stack.push(c);
        }
        for (int i = 0; i < s.length(); i++) {
            initialChars[i] = stack.pop();
        }
        System.out.println("reversed string is: " + new String(initialChars));
        return new String(initialChars);
    }

    //TODO: need to check later
    public int[] integerArr(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] newArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            int poppedVal = stack.pop();
            newArr[i] = poppedVal;
            arr[i] = newArr[i];
        return arr;
    }

    public char[] reversedStringUsingCharArr(char[] s) {
        Stack<Character> stack = new Stack<>();
        char[] reversedCharArr = new char[s.length];
        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }
        for (int i = 0; i < s.length; i++) {
            char poppedValue = stack.pop();
            reversedCharArr[i] = poppedValue;
            s[i] = reversedCharArr[i];
        }
        System.out.println(s);
        return s;
    }

    // its working as expected for a char[] but not displaying values properly for int[]
    public static void main(String[] args) {
        ReverseStr rStr = new ReverseStr();
        rStr.reverseString1("man");
        int[] intArr = {1, 3, 5, 7, 9};
        System.out.println("Before intArr reverse: "+intArr); //TODO: why this is not getting printed
        System.out.println("After intArr reverse: "+rStr.integerArr(intArr));
        char[] charArr = {'r', 'a', 'j'};
        rStr.reversedStringUsingCharArr(charArr);
    }
}
