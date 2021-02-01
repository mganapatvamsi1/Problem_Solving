package others.stacks;

import others.SLL;

import java.util.EmptyStackException;
import java.util.Stack;

/*
Time Complexity is O(1)
Space Complexity is O(1)
 */
public class StackLinkedList {

    private StackListNode top;
    private int length;

    public static class StackListNode {
        private int data;
        private StackListNode next;
        public StackListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public StackLinkedList() {
        top = null;
        length = 0;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(int data) {
        StackListNode temp = new StackListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int result = top.data;
        top = top.next;
        length--;
        System.out.println("popped value is: "+result);
        return result;
    }

    public int peek() {
        if (isEmpty()) throw new EmptyStackException();
        System.out.println("peek is: "+top.data);
        return top.data;//"top" is the last inserted node in the stack
    }

    public static void main(String[] args) {
        StackLinkedList stackLL = new StackLinkedList();
        stackLL.push(5);
        stackLL.peek(); // 5
        stackLL.push(10);
        stackLL.peek(); // 10
        stackLL.push(15);
        stackLL.peek(); // 15
        stackLL.push(20);
        stackLL.peek(); // 20

        stackLL.pop(); // 20
        stackLL.peek(); // 15
        stackLL.pop(); // 15
        stackLL.peek(); // 10
        stackLL.pop(); // 10
        stackLL.peek(); // 5
    }
}
