package algoexpert.stacks;

import java.util.Stack;

public class Palindrome {

    public static boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        char[] charArr = str.toCharArray();
        for (char c: charArr) stack.push(c);
        for (int i = 0; i < str.length(); i++) charArr[i] = stack.pop();
        // if (str.equals(new String(forwardChars) ) ) return true;
        // return false;
        return str.equals(new String(charArr));
    }

    public static boolean isPalindrome2(String str) {
        String reversedStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedStr += str.charAt(i);
        }
        return str.equals(reversedStr);
    }

    public static void main(String[] args) {
        isPalindrome("abcdcba");
    }
}
