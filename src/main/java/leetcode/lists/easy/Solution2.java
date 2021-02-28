package leetcode.lists.easy;

//Remove Nth Node From End of List

public class Solution2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid value: n =  "+n);
        }
        ListNode temp = new ListNode(-1);
        temp.next = head;

        ListNode mainPtr = temp;
        ListNode refPtr = temp;
        int count = 0;
        while (count < n) {
            if (refPtr == null) {
                throw new IllegalArgumentException(n+" is greater than number of elements in the list ");
            }
            mainPtr = mainPtr.next;
            count++;
        }
        while (mainPtr != null && mainPtr.next != null) {
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }
        refPtr.next = refPtr.next.next;
        return temp.next;
    }

    public void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val+" --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode fifth = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = fifth;
        fifth.next = null;
        solution2.display(one);
        System.out.println("removing 2nd element from the last:: "+solution2.removeNthFromEnd(one, 2).val);
        solution2.display(one);
    }
}


/*
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid value: n =  "+n);
        }
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;
        while (count < n) {
            if (refPtr == null) {
                throw new IllegalArgumentException(n+" is greater than number of elements in the list ");
            }
            mainPtr = mainPtr.next;
            count++;
        }
        while (mainPtr != null) {
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }
        return refPtr;
    }
 */

/*
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp_head = new ListNode(0);
        temp_head.next = head;
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        int count = 0;
        while (count < n) {
            fastPointer = fastPointer.next;
            count++;
        }
        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        slowPointer.next = slowPointer.next.next;
        return temp_head.next;
    }
 */



