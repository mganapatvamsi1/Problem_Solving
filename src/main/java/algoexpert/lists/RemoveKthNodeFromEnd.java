package algoexpert.lists;

/*
"Remove Kth node from the end".
Write a function that takes in the head of a SLL and an integer k and removes the kth node from the end of the list.
The removal should be done in place, meaning that the original data structure should be mutated (no new structure should be created.)
Furthermore, the input head of the linked list should remain the head of the linked list after the removal is done, even if the head
is the node that's supposed to be removed. In other words, if the head is the node that's supposed to be removed, your function should
simply mutate its value and next pointer.
Note that the function doesn't need to return anything.
You can assume that the input LinkedList will always have atleast 2 nodes and, more specifically, atleast k nodes.
Each LinkedList node has an integer value as well as a next node pointing to the next node in the list or to None/null if it's the tail of the list.
 */
public class RemoveKthNodeFromEnd {

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        if (head == null) return;
        if (k <= 0) {
            throw new IllegalArgumentException("Invalid value: k = "+k);
        }
        LinkedList current = head;
        LinkedList temp = head;
        LinkedList ref = head;
        int count = 0;
        while (count < k) {
            count++;
            temp = temp.next;
        }
        while (temp != null) {
            temp = temp.next;
            ref = current;
            current = current.next;
        }
        if (ref != current) ref.next = current.next;
        else {
            head.value = head.next.value;
            head.next = head.next.next;
        }
    }



    public static void main(String[] args) {
        RemoveKthNodeFromEnd removeKthNodeFromEnd = new RemoveKthNodeFromEnd();


    }
}
