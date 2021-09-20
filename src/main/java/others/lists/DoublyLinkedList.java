package others.lists;

public class DoublyLinkedList {

    // Implementing and representing a doubly linked list (2 way Linked List)  /* started */
    private DListNode head;
    private DListNode tail;
    private int length;

    public static class DListNode {
        private int data;
        private DListNode previous;
        private DListNode next;

        public DListNode(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }
    // Implementing and representing a doubly linked list (2 way Linked List)  /* ended */


    // printing the elements in forward direction
    //TODO: Time complexity and space complexity are O(n) and O(n) for printing in forward
    public void printForward() {
        if (head == null) {
            return;
        }
        DListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }


    // printing the elements in backward direction
    //TODO: Time complexity and space complexity are O(n) and O(n) for printing from backward
    public void printBackward() {
        if (head == null) {
            return;
        }
        DListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    public void insertStart(int value) {
        DListNode newNode = new DListNode(value);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void insertLast(int value) {
        DListNode newNode = new DListNode(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            DListNode current = head;
            while (null != current.next) {
                current = current.next;
            }
            current.next = newNode;
            newNode.previous = current;
            tail = newNode;
            length++;
        }
    }

    public void insertLast2(int value) {
        DListNode newNode = new DListNode(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    public void insertAtIndex(int data, int position) {
        DListNode newNode = new DListNode(data);
        if (isEmpty()) {
            head = newNode;
        } else if (position == 0) {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        } else {
            DListNode refPtr = null;
            DListNode mainPtr = head;
            int count = 0;
            while (count <= position - 1) {
                count++;
                refPtr = mainPtr;
                mainPtr = mainPtr.next;
            }
            refPtr.next = newNode;
            newNode.previous = refPtr;
            newNode.next = mainPtr;
            if (mainPtr != null) {
                mainPtr.previous = newNode;
            }
            length++;
        }
    }

    public DListNode deleteFirst() {
        if (head == null) {
            return null;
        }
        DListNode temp = head;
        head = head.next;
        temp.next = null;
        temp.previous = null;
        length--;
        return temp;
    }

    public DListNode deleteLast() {
        if (head == null) {
            return null;
        }
        DListNode mainPtr = head;
        DListNode refPtr = head;
        while (null != mainPtr.next) {
            refPtr = mainPtr;
            mainPtr = mainPtr.next;
        }
        refPtr.next = null;
        mainPtr.previous = null;
        length--;
        return mainPtr;
    }

    //TODO: to verify this method later
    public DListNode deleteLast2() {
        if (head == null || tail == null) return null;
        DListNode current = tail;
        tail.previous.next = null;
        tail = tail.previous;
        current.previous = null;
        length--;
        return current;
    }

    public DListNode deleteAtPosition(int position) {
        if (position == 0) {
            DListNode temp = head;
            head = head.next;
            temp.next = null;
            temp.previous = null;
            return temp;
        }
        int count = 0;
        DListNode refPtr = null;
        DListNode mainPtr = head;
        while (count <= position - 1) {
            refPtr = mainPtr;
            mainPtr = mainPtr.next;
            count++;
        }
        refPtr.next = mainPtr.next;
        mainPtr.previous = null;
        if (mainPtr.next != null) {
            mainPtr.next.previous = refPtr.next;
        }
        length--;
        return mainPtr;
    }


    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        // inserting in the start of a doubly linked list
        dll.insertStart(5);
        dll.insertStart(3);
        dll.printForward(); // 3 --> 5 --> null
        dll.printBackward(); // 5 --> 3 --> null

        // inserting in the end of a doubly linked list
        dll.insertLast(7);
        dll.insertLast(9);
        dll.printForward(); // 3 --> 5 --> 7 --> 9 --> null

        // inserting at a certain position in a doubly linked list
        dll.insertAtIndex(4, 2);
        dll.printForward(); // 3 --> 5 --> 4 --> 7 --> 9 --> null
        dll.insertAtIndex(1, 4);
        dll.printForward(); // 3 --> 5 --> 4 --> 7 --> 1 --> 9 --> null
        dll.insertAtIndex(2, 6);
        dll.printForward(); // 3 --> 5 --> 4 --> 7 --> 1 --> 9 --> 2 --> null

        // deleting the start node
        dll.deleteFirst();
        dll.deleteFirst();
        dll.printForward(); // 4 --> 7 --> 1 --> 9 --> 2 --> null

        // deleting the last node
        dll.deleteLast();
        dll.printForward(); // 4 --> 7 --> 1 --> 9 --> null
        dll.deleteLast2();
        dll.printForward(); // 4 --> 7 --> 1 --> null

        // deleting at a certain position
        dll.deleteAtPosition(2);
        dll.printForward(); // 4 --> 7 --> null
        dll.deleteAtPosition(0);
        dll.printForward(); // 7 --> null
    }

}
