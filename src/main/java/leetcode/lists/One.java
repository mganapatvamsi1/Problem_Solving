package leetcode.lists;

/*
Write a function to delete a node in a singly-linked list.
You will not be given access to the head of the list,
instead you will be given access to the node to be deleted directly.
It is guaranteed that the node to be deleted is not a tail node in the list.
 */
public class One {

    public ListNode1 head;

    public static class ListNode1 {
        private int data;
        private ListNode1 next;
        public ListNode1(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        ListNode1 current = head;
        while (current != null) {
            System.out.print(current.data+" --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public ListNode1 deleteGivenNode(int value) {
        if (head == null) {
            return null;
        }
        ListNode1 mainPtr = head;
        ListNode1 tmp = head;
        ListNode1 refPtr = null;

        while (mainPtr != null) {
            refPtr = mainPtr;
            mainPtr = mainPtr.next;
            if (mainPtr != null && mainPtr.data == value && mainPtr.next != null) {
                refPtr.next = mainPtr.next;
                return mainPtr;
            } else if (mainPtr == null) {
                head = tmp.next;
                return tmp.next;
            }
        }
        return mainPtr;
    }

//    public void deleteNode(ListNode1 node) {
//        if (head == null) {
//            return;
//        }
//        ListNode1 mainPtr = head;
//        ListNode1 tmp = head;
//        ListNode1 refPtr = null;
//        while (mainPtr != null) {
//            refPtr = mainPtr;
//            mainPtr = mainPtr.next;
//            if (mainPtr != null && mainPtr.data == node.data) {
//                refPtr.next = mainPtr.next;
//            } else if (mainPtr == null) {
//                head = tmp.next;
//            }
//        }
//
//    }

    public void insertFirst(int value) {
        ListNode1 newNode = new ListNode1(value);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void deleteNode(ListNode1 node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }


    public static void main(String[] args) {
        One one = new One();
        // example 1
//        one.insertFirst(9);
//        one.insertFirst(1);
//        one.insertFirst(5);
//        one.insertFirst(4);
//        one.display(); // 4 --> 5 --> 1 --> 9 --> null
//        one.deleteGivenNode(5);
//        one.display(); //ans::  4 --> 1 --> 9 --> null

        // example 2
//        one.insertFirst(9);
//        one.insertFirst(1);
//        one.insertFirst(5);
//        one.insertFirst(4);
//        one.deleteGivenNode(1);
//        one.display(); //ans:: 4 --> 5 --> 9 --> null

        // example 3
//        one.insertFirst(4);
//        one.insertFirst(3);
//        one.insertFirst(2);
//        one.insertFirst(1);
//        one.display(); // 1 --> 2 --> 3 --> 4 --> null
//        one.deleteGivenNode(3);
//        one.display(); // 1 --> 2 --> 4 --> null

        // example 4
//        one.insertFirst(1);
//        one.insertFirst(0);
//        one.display(); // 0 --> 1 --> null
//        one.deleteGivenNode(0);
//        one.display();

        // example 5
//        one.insertFirst(-99);
//        one.insertFirst(5);
//        one.insertFirst(-3);
//        one.display(); // -3 --> 5 --> -99 --> null
//        ListNode1 node1 = new ListNode1(-3);
//        one.deleteNode(node1);
////        one.deleteGivenNode(-3);
//        one.display();

    }
}
