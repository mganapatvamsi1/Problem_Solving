package leetcode.stacks;

import java.util.LinkedList;
import java.util.Queue;

/*
Implement a last in first out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal queue (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue), as long as you use only a queue's standard operations.

 */
public class ImplementStackUsingQueues {

    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    private int top;
    public ImplementStackUsingQueues() {
        top = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queue.size() > 1) {
            top = queue.remove();
            queue2.add(top);
        }
        int val = queue.remove();
        Queue<Integer> temp = queue;
        queue = queue2;
        queue2 = temp;

        return val;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */