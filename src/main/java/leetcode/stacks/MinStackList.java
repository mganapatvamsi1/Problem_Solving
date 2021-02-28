package leetcode.stacks;

import java.util.EmptyStackException;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 */
class MinStackList {

    /** initialize your data structure here. */
    public MinStackList() {
        this.top = null;
        this.length = 0;
    }

    private ListNode top;
    private int length;

    private static class ListNode {
        private int data;
        private ListNode next;
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int getLength() {
        return length;
    }

    public void push(int x) {
        ListNode temp = new ListNode(x);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        if (top != null) {
            int result = top.data;
            top = top.next;
            length--;
            return result;
        }
        return 0;

    }

    public int top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        if (top != null) {
            return top.data;
        }
        return 0;
    }

    //TODO:: this fails when top == 0
    public int getMin() {
        int minValue = Integer.MAX_VALUE;
        while (top != null) {
            if (minValue > top.data) {
                minValue = top.data;
            }
            top = top.next;
        }
        return minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */