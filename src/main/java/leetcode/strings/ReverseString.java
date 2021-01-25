package leetcode.strings;

import java.util.Stack;

public class ReverseString {
// APPROACH-1
//    public void reverseString(char[] s) {
//        char[] reverseArr = new char[s.length];
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length; i++) {
//            System.out.print(stack.push(s[i]));
//        }
//        System.out.println();
//        for (int i = 0; i < s.length; i++) {
//            Character poppedValue = stack.pop();
//            reverseArr[i] = poppedValue;
//            s[i] = reverseArr[i];
//        }
//
//    }

    // APPROACH-2
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            Character temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char[] firstInput = {'h','e','l','l','o'};
        reverseString.reverseString(firstInput);
    }
}
