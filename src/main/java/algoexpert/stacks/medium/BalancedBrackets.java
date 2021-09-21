package algoexpert.stacks.medium;

import java.util.Stack;

public class BalancedBrackets {

    public static boolean balancedBrackets1(String str) {
        Stack<Character> stack = new Stack<>();
        for (char character : str.toCharArray()) {
            if (character == '(' || character == '{' || character == '[') stack.push(character);
            if (character == ')' || character == '}' || character == ']') {
                if (character == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
                else if (character == '}' && !stack.isEmpty() && stack.peek() == '{') stack.pop();
                else if (character == ']' && !stack.isEmpty() && stack.peek() == '[') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean balancedBrackets2(String str) {
        if (str.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current == '{' || current == '(' || current == '[') {
                stack.push(current);
            }

            if (current == '}' || current == ')' || current == ']') {
                if (stack.isEmpty()) return false;
                char last = stack.peek();
                if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[') {
                    stack.pop();
                } else return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean balancedBrackets3(String str) {
        Stack<Character> stack = new Stack<>();
        for (char character: str.toCharArray()) {
            if (character == '(' || character == '{' || character == '[') stack.push(character);
            else if (character == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
            else if (character == '}' && !stack.isEmpty() && stack.peek() == '{') stack.pop();
            else if (character == ']' && !stack.isEmpty() && stack.peek() == '[') stack.pop();
            else if (character == '+' || character == '-' || character == '*' || character == '/' ||
                    character == '%' || character == '&' || character == '@' || character == 'Q' ||
                    Character.isLetterOrDigit(character)) {
            }
            else return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("test1: "+balancedBrackets1("([])(){}(())()()"));
        System.out.println("test2: "+balancedBrackets2("([])(){}(())()()"));
        System.out.println("test3: "+balancedBrackets3("(agwgg)([ghhheah%&@Q])"));
        System.out.println("test1: "+balancedBrackets1("(agwgg)([ghhheah%&@Q])"));
        System.out.println("test2: "+balancedBrackets2("(agwgg)([ghhheah%&@Q])"));
        System.out.println("test3: "+balancedBrackets3("(agwgg)([ghhheah%&@Q])"));
    }
}
