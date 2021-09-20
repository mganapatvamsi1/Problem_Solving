package algoexpert.lists;

/*
"Remove duplicates from linked list".
You're given the head of a SinglyLinkedList whose nodes are in sorted order with respect to their values.
Write a function that returns a modified version of the Linked List that doesn't contain any nodes with
duplicate values. The Linked List should be modified in place (i.e, you shouldn't create a brand new list),
and the modified Linked List should still have its nodes sorted with respect to their values.
 */

public class RemoveDuplicates {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList current = linkedList;
        if (current == null) return null;

        while (current.next != null) {
            if (current.value == current.next.value) current.next = current.next.next;
            else current = current.next;
        }
        return linkedList;
    }

    public static void main(String[] args) {

    }
}
