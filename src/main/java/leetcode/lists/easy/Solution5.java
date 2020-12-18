package leetcode.lists.easy;
/*
// Merge 2 sorted lists
Merge two sorted linked lists and return it as a new sorted list.
The new list should be made by splicing together the nodes of the first two lists.
*/

public class Solution5 {

    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(-1);
        ListNode head = newList;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        } else {
            head.next = l2;
        }
        return newList.next;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = null;

        ListNode test1 = new ListNode(2);
        ListNode test2 = new ListNode(4);
        ListNode test3 = new ListNode(6);
        test1.next = test2;
        test2.next = test3;
        test3.next = null;

        solution5.mergeTwoSortedLists(one, test1);

    }

}
