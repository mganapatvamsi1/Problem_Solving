package others.lists;

/* Representing a SinglyLinkedList (SLL) */
public class SLL {
    private ListNode head;

    public static class ListNode {
        private int data;
        private ListNode next; //  reference to next ListNode in the list

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /* Printing elements of a SLL */
    //TODO:: Time Complexity is O(n) and Space Complexity is O(1)
    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data+" --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /* Finding the length of a SLL */
    //TODO:: Time Complexity is O(n) and Space Complexity is O(1)
    public int length() {
        if (head == null) {
            return 0;
        }
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /* Inserting a node at the beginning of a SLL */
    //TODO:: Time Complexity is O(1) and Space Complexity is O(1)
    public void insertStart(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /* Inserting a node at the end of a SLL */
    //TODO:: Time Complexity is O(n) and Space Complexity is O(1)
    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        } else {
            ListNode current = head;
            while (null != current.next) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /* Inserting a node at a given position of a SLL */
    //TODO:: Time Complexity is O(n) and Space Complexity is O(1)
    public void insertAtPosition(int value, int position) {
        ListNode newNode = new ListNode(value);
        ListNode refPtr = null;
        ListNode mainPtr = head;
        if (head == null) {
            head = newNode;
            return;
        } else if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            int count = 0;
            while (count <= position - 1) {
                count++;
                refPtr = mainPtr;
                mainPtr = mainPtr.next;
            }
            refPtr.next = newNode;
            newNode.next = mainPtr;
        }
    }
    public void insertAtPosition2(int value, int position) {
        ListNode newNode = new ListNode(value);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode previous = head;
            int count = 0;
            while (count < position - 1) {
                count++;
                previous = previous.next;
            }
            ListNode current = previous.next;
            newNode.next = current;
            previous.next = newNode;
        }
    }

    /* Deleting a node in the start of a SLL */
    //TODO:: Time Complexity is O() and Space Complexity is O()
    public ListNode deleteFirst() {
        if (head == null) {
            return null;
        }
        ListNode tmp = head;
        head = head.next;
        tmp.next = null;
        return tmp;
    }

    /* Deleting a node in the end of a SLL */
    //TODO:: Time Complexity is O() and Space Complexity is O()
    public ListNode deleteLast() {
        if (head == null) {
            return null;
        }
        ListNode refPtr = null;
        ListNode mainPtr = head;
        while (null != mainPtr.next) {
            refPtr = mainPtr;
            mainPtr = mainPtr.next;
        }
        refPtr.next = null;
        return mainPtr;
    }

    /* Deleting a node in a SLL at a given position */
    //TODO:: Time Complexity is O() and Space Complexity is O()
    public ListNode deleteAtPosition(int position) {
        ListNode mainPtr = head;
        ListNode refPtr = null;
        int count = 0;
        if (position == 0) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return temp;
        } else {
            while (count <= position - 1) {
                count++;
                refPtr = mainPtr;
                mainPtr = mainPtr.next;
            }
            ListNode current = refPtr.next;
            refPtr.next = refPtr.next.next;

            return current;
        }
    }
    public void deleteAtPosition2(int position) {
        if (position == 0) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
        } else {
            ListNode previous = head;
            int count = 0;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
            current.next = null;
        }
    }

    /* Searching an element in a SLL */
    //TODO:: Time Complexity is O() and Space Complexity is O()
    public boolean search(int key) {
        if (head == null) {
            return false;
        }
        ListNode current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /* Reversing a SLL */
    //TODO:: Time Complexity is O() and Space Complexity is O()
    public ListNode reversingSLL() {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    /* Finding the middle element in a SLL */
    //TODO:: Time Complexity is O(n) and Space Complexity is O(1)
    public ListNode findMiddleElement() {
        if (head == null) {
            return null;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    /* Finding nth element from the last of a SLL */
    //TODO: Time Complexity is O(n) and space complexity is O(1)
    public ListNode findNthFromLast(int numberFromLast) {
        if (head == null) {
            return null;
        }
        if (numberFromLast <= 0) {
            throw new IllegalArgumentException("Invalid value: n =  "+numberFromLast);
        }
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int counter = 0;
        while (counter < numberFromLast) {
            if (refPtr == null) {
                throw new IllegalArgumentException(numberFromLast+" is greater than number of elements in the list ");
            }
            refPtr = refPtr.next;
            counter++;
        }
        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    /* Finding nth element from the start of a SLL */
    //TODO: Time Complexity is O(n) and space complexity is O(1)
    public ListNode findNthFromStart(int numberFromStart) {
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int counter = 0;
        while (counter < numberFromStart) {
            mainPtr = refPtr;
            refPtr = refPtr.next;
            counter++;
        }
        return mainPtr;
    }


    /* Creating a SLL */
    public static void main(String[] args) {
        SLL sll = new SLL();
        sll.head = new ListNode(5);
        ListNode second = new ListNode(10);
        ListNode third = new ListNode(15);
        ListNode fourth = new ListNode(20);

        // Connecting the SLL to form a chain
        sll.head.next = second; // 5 --> 10
        second.next = third; // 5 --> 10 --> 15
        third.next = fourth; // 5 --> 10 --> 15 --> 20

      // Printing elements of a SLL
        sll.display();

        // finding length of a SLL
        System.out.println("length of this SLL is:: "+sll.length());

        // inserting a node in the start of a SLL
        sll.insertStart(3);
        sll.display(); // 3 --> 5 --> 10 --> 15 --> 20 --> null
        sll.insertStart(1);
        sll.display(); // 1 --> 3 --> 5 --> 10 --> 15 --> 20 --> null

        // inserting node in the last of a SLL
        sll.insertLast(23);
        sll.display();
        sll.insertLast(26);
        sll.display();

        // inserting a node at a certain position in SLL
        sll.insertAtPosition(13, 1);
        sll.display();
        sll.insertAtPosition(30, 3);
        sll.display(); // 1 --> 13 --> 3 --> 30 --> 5 --> 10 --> 15 --> 20 --> 23 --> 26 --> null

        // deleting first node in the SLL
        sll.deleteFirst();
        sll.display(); // 13 --> 3 --> 30 --> 5 --> 10 --> 15 --> 20 --> 23 --> 26 --> null
        sll.deleteFirst();
        sll.display(); // 3 --> 30 --> 5 --> 10 --> 15 --> 20 --> 23 --> 26 --> null

        // deleting last node in a SLL
        System.out.println("deleting the last node:: "+sll.deleteLast().data);
        sll.display(); // 3 --> 30 --> 5 --> 10 --> 15 --> 20 --> 23 --> null
        System.out.println("deleting the last node:: "+sll.deleteLast().data);
        sll.display(); // 3 --> 30 --> 5 --> 10 --> 15 --> 20 --> null

        // deleting a node at a certain position
        System.out.println("deleting node at a certain position:: "+sll.deleteAtPosition(1).data); // 30
        sll.display(); // 3 --> 5 --> 10 --> 15 --> 20 --> null
        System.out.println("deleting node at a certain position:: "+sll.deleteAtPosition(3).data); // 15
        sll.display(); // 3 --> 5 --> 10 --> 20 --> null

        // searching for an element in a SLL
        System.out.println("seaching for 3::: "+sll.search(3)); //true
        System.out.println("seaching for 20::: "+sll.search(20)); //true
        System.out.println("seaching for 22::: "+sll.search(22)); //false

        // reversing SLL
        ListNode reverseSllHead = sll.reversingSLL();
        sll.head = reverseSllHead;
        sll.display(); // 20 --> 10 --> 5 --> 3 --> null

        // finding the middle element in a SLL
        System.out.println("the middle element in the SLL is:: "+sll.findMiddleElement().data);

        sll.display();
        //finding the nth node from the last of a SLL
        System.out.println("the 3rd element from the last of SLL is:: "+sll.findNthFromLast(3).data); // 10
        System.out.println("the 2nd element from the last of SLL is:: "+sll.findNthFromLast(2).data); // 5

        sll.display(); // 20 --> 10 --> 5 --> 3 --> null
        // finding the nth node from the start of a SLL
        System.out.println("the 3rd element from the start is:: "+sll.findNthFromStart(4).data); // 3
        System.out.println("the 2nd element from the start is:: "+sll.findNthFromStart(1).data); // 20

        sll.insertLast(30);
        sll.insertStart(1);
        sll.insertStart(4);
        sll.display(); // 4 --> 1 --> 20 --> 10 --> 5 --> 3 --> 30 --> null
    }

}
