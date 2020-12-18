package leetcode.lists.easy;

/* Palindrome Linked List */
/*
METHOD 1 (Use a Stack)

A simple solution is to use a stack of list nodes. This mainly involves three steps.
Traverse the given list from head to tail and push every visited node to stack.
Traverse the list again. For every visited node, pop a node from stack and compare data of popped node with currently visited node.
If all nodes matched, then return true, else false.
 */

import javax.xml.soap.Node;
import java.util.Stack;

class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3() {}
    ListNode3(int val) { this.val = val; }
    ListNode3(int val, ListNode3 next) { this.val = val; this.next = next; }
}

public class Solution3 {

    public static boolean isPalindrome(ListNode3 head) {
        ListNode3 slow = head;
        boolean isPalindrome = true;
        Stack<Integer> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow.val);
            slow = slow.next;
        }
        while (head != null) {
            int valueToBePoppedFromStack = stack.pop();
            if (head.val == valueToBePoppedFromStack) {
                isPalindrome = true;
            } else  {
                isPalindrome = false;
                break;
            }
            head = head.next;
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        ListNode3 one = new ListNode3(1);
        ListNode3 two = new ListNode3(3);
        ListNode3 three = new ListNode3(5);
        ListNode3 four = new ListNode3(3);
        ListNode3 five = new ListNode3(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = null;
        boolean condition = isPalindrome(one);
        System.out.println("isPalindrome:: "+condition);
    }
}
