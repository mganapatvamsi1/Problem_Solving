package others.stacks;

import java.util.Stack;

/*
Evaluate postfix expression using stacks in java
 */
public class EvaluatePostfixExpr {

    public int evaluatePostFix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);

            if (!Character.isDigit(character)) {
                Integer firstPoppedValue = stack.pop();
                Integer secondPoppedValue = stack.pop();

                switch(character) {
                    case '+':
                        stack.push(secondPoppedValue + firstPoppedValue);
                        break;
                    case '-':
                        stack.push(secondPoppedValue - firstPoppedValue);
                        break;
                    case '*':
                        stack.push(secondPoppedValue * firstPoppedValue);
                        break;
                    case '/':
                        stack.push(secondPoppedValue / firstPoppedValue);
                        break;
                    case '%':
                        stack.push(secondPoppedValue % firstPoppedValue);
                        break;
                }
            } else {
                stack.push(Character.getNumericValue(character));
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        EvaluatePostfixExpr epfExpr = new EvaluatePostfixExpr();
        System.out.println("after evaluating postFix: "+epfExpr.evaluatePostFix("946*+4-"));
    }
}
