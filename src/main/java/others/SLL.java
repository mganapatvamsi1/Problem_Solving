package others;

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
    }

}
