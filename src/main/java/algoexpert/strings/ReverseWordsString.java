package algoexpert.strings;

import java.util.Stack;

public class ReverseWordsString {

    // spaces are not coming
    public static String reverseWordsInString(String string) {
        Stack<String> stack = new Stack<>();
        String temp = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                stack.add(temp);
                temp = "";
            } else {
                temp += string.charAt(i);
            }
        }
        stack.add(temp);
        while (!stack.isEmpty()) {
            temp = "";
            temp += stack.peek();
            stack.pop();
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println("reverseStr: "+reverseWordsInString("AlgoExpert   is the    best"));
    }

}
