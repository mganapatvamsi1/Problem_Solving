package algoexpert.stacks.medium;

import java.util.ArrayList;

public class SortStack {

    private static ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        if (stack.size() == 0) return stack;
        int top = stack.remove(stack.size() - 1);
        sortStack(stack);
        insertInStack(stack, top);

        return stack;
    }

    private static void insertInStack(ArrayList<Integer> stack, int value) {
        if (stack.size() == 0 || stack.get(stack.size() - 1) <= value) {
            stack.add(value);
            return;
        }
        int top = stack.remove(stack.size() - 1);
        insertInStack(stack, value);
        stack.add(top);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println("given list: "+list);
        System.out.println("In-place sorted list: "+sortStack(list));
    }
}
