package others.lists;

import java.util.NoSuchElementException;

public class CircularLinkedList {

    private CListNode last;
    private int length;

    public static class CListNode {
        private int data;
        private CListNode next;

        public CListNode(int data) {
            this.data = data;
        }
    }

    public CircularLinkedList() {
        last = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void display() {
        if (last == null) {
            return;
        }
        CListNode first = last.next;
        while (first != last) {
            System.out.print(first.data + " --> ");
            first = first.next;
        }
        System.out.println(first.data);
    }

    public int getLength() {
        if (last == null) {
            return 0;
        }
        int count  = 1;
        CListNode first = last.next;
        while (first != last) {
            first = first.next;
            count++;
        }
        return count;
    }

    public void insertLast(int value) {
        CListNode newNode = new CListNode(value);
        if (last == null) {
            last = newNode;
            return;
        }
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
        length++;
    }

    public void insertStart(int value) {
        CListNode newNode = new CListNode(value);
        if (last == null) {
            last = newNode;
            return;
        }
        newNode.next = last.next;
        last.next = newNode;
        length++;
    }

    public CListNode deleteStart() {
        if (last == null) {
            return null;
        } else if (last.next == null) {
            return last;
        }
        if (isEmpty()) {
            throw new NoSuchElementException("CSLL is already empty.");
        }
        CListNode first = last.next;
        last.next = last.next.next;
        first.next = null;
        length--;
        return first;
    }

    public CListNode deleteLast() {
        if (last == null) {
            return null;
        } else if (last.next == null) {
            return last;
        }
        if (isEmpty()) {
            throw new NoSuchElementException("CSLL is alreadt empty.");
        }
        CListNode first = last.next;
        CListNode refPtr = null;
        while (first != last) {
            refPtr = first;
            first = first.next;
        }
        refPtr.next = last.next;
        last.next = null;
        last = refPtr;
        return last;
    }

    public void createCircularLinkedList() {
        CListNode first = new CListNode(1);
        CListNode second = new CListNode(5);
        CListNode third = new CListNode(10);
        CListNode fourth = new CListNode(15);
        CListNode fifth = new CListNode(20);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = first;
        last = fifth;
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.createCircularLinkedList();
        cll.display(); // 1 --> 5 --> 10 --> 15 --> 20

        System.out.println("length of the circularLL is:: "+cll.getLength());

        cll.insertStart(7);
        cll.display(); // 7 --> 1 --> 5 --> 10 --> 15 --> 20
        cll.insertStart(13);
        cll.display(); // 13 --> 7 --> 1 --> 5 --> 10 --> 15 --> 20

        cll.insertLast(2);
        cll.display(); // 13 --> 7 --> 1 --> 5 --> 10 --> 15 --> 20 --> 2
        cll.insertLast(9);
        cll.display(); // 13 --> 7 --> 1 --> 5 --> 10 --> 15 --> 20 --> 2 --> 9

        cll.deleteStart();
        cll.display(); // 7 --> 1 --> 5 --> 10 --> 15 --> 20 --> 2 --> 9
        cll.deleteStart();
        cll.display(); // 1 --> 5 --> 10 --> 15 --> 20 --> 2 --> 9

        cll.deleteLast();
        cll.display(); // 1 --> 5 --> 10 --> 15 --> 20 --> 2
        cll.deleteLast();
        cll.display(); // 1 --> 5 --> 10 --> 15 --> 20
        cll.deleteLast();
        cll.display(); // 1 --> 5 --> 10 --> 15
    }
}
