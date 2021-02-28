package leetcode.stacks;


import java.util.Stack;

/*
Order Matters
we need to see the corresponding character
--> we will push into the stack when we see a character with an opening brace
--> when we see a closing character we need to check 2 things:
a) make sure stack is not empty
b) make sure top of the stack contains the corresponding
   closing character that we expect to see.
 */

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
