package leetcode.lists.easy;

/**
 * Definition for singly-linked list.

 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


public class DefiningSLL {
    public ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode previous = null;
        ListNode next = head;
        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }


    public static void main(String[] args) {
        DefiningSLL sol = new DefiningSLL();
        ListNode one = new ListNode(5);
        ListNode two = new ListNode(10);
        ListNode three = new ListNode(15);
        one.next = two;
        two.next = three;
        three.next = null;
        sol.reverseList(one);
    }

}