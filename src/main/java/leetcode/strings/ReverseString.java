package leetcode.strings;

import java.util.Stack;

public class ReverseString {

    public void reverseString(char[] s) {
        char[] reverseArr = new char[s.length];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            System.out.print(stack.push(s[i]));
        }
        System.out.println();
        while (stack.size() != 0) {
            Character poppedValue = stack.pop();
            System.out.print(stack.pop());
        }
        for (int i = 0; i < s.length; i++) {
            Character poppedValue = stack.pop();
            reverseArr[i] = poppedValue;
        }

    }


    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char[] firstInput = {'h','e','l','l','o'};
        reverseString.reverseString(firstInput);
    }
}
