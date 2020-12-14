package others;

public class Sll2 {

    private LNode head;

    public static class LNode {
        private int data;
        private LNode next;

        public LNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        LNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public LNode insertFirst(int value) {
        LNode newNode = new LNode(value);
        if (head == null) {
            head = newNode;
            return null;
        } else {
            newNode.next = head;
            head = newNode;
            return head;
        }
    }

    public LNode insertLast(int value) {
        LNode newNode = new LNode(value);
        if (head == null) {
            head = newNode;
            return null;
        }
        LNode current = head;
        while (null != current.next) {
            current = current.next;
        }
        current.next = newNode;
        return current;
    }

    /* removing duplicates from a sorted SLL */
    //TODO:: time complexity is O(n) and space complexity is O(1)
    public LNode removeDuplicates() {
        if (head == null) {
            return null;
        }
        LNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    /* inserting a node in a sorted SLL */
    //TODO:: time complexity is O() and space complexity is O()
    public LNode insertNodeSortedList(int value) {
        LNode newNode = new LNode(value);
        if (head == null) {
            newNode.next = head;
            head = newNode;
            return newNode;
        }
        LNode current = head;
        LNode refPtr = null;
        while (current != null && newNode.data >= current.data) {
            refPtr = current;
            current = current.next;
        }
        refPtr.next = newNode;
        newNode.next = current;
        return head;
    }

    /* Removing a given key in a sorted SLL */
    public LNode removingKey(int value) {
        if (head == null) {
            return null;
        }
        LNode current = head;
        LNode refPtr = null;
        while (current != null && current.data != value) {
            refPtr = current;
            current = current.next;
        }
        if (current == null) return null;
        LNode tmp = refPtr.next;
        refPtr.next = refPtr.next.next; // refPtr.next = current.next;
        return tmp; // return current;
    }



    public static void main(String[] args) {
        Sll2 testSll = new Sll2();
        testSll.insertFirst(3);
        testSll.insertFirst(1);
        testSll.display();
        testSll.insertLast(5);
        testSll.insertLast(7);
        testSll.insertLast(9);
        testSll.display(); // 1 --> 3 --> 5 --> 7 --> 9 --> null (this is a sorted SLL)
        testSll.insertFirst(1);
        testSll.insertFirst(1);
        testSll.insertLast(9);
        testSll.display(); // 1 --> 1 --> 1 --> 3 --> 5 --> 7 --> 9 --> 9 --> null

        // Remove duplicates from a sorted SLL
        testSll.removeDuplicates();
        testSll.display(); // 1 --> 3 --> 5 --> 7 --> 9 --> null

        // inserting in sorted linked list
        testSll.insertNodeSortedList(2);
        testSll.display();
        testSll.insertNodeSortedList(4); // 1 --> 2 --> 3 --> 4 --> 5 --> 7 --> 9 --> null
        testSll.display();

        // removing given key in a sorted SLL
        testSll.removingKey(9);
        testSll.display();


        // detecting a loop


        // converting a unsorted list to a sorted one

    }
}
