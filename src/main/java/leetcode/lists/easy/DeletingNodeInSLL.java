package leetcode.lists.easy;

/*
Write a function to delete a node in a singly-linked list.
You will not be given access to the head of the list,
instead you will be given access to the node to be deleted directly.
It is guaranteed that the node to be deleted is not a tail node in the list.
 */
class DeletingNodeInSLL {
    public ListNode head;

    public static class ListNode {
        private int data;
        private ListNode next;
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public void display() {
        ListNode current  = head;
        while(current != null) {
            System.out.print(current.data+" --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }


//    public void deleteNode(ListNode node) {
//        if (head == null) {
//            return;
//        }
//        ListNode mainPtr = head;
//        ListNode tmp = head;
//        ListNode refPtr = null;
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

    public void deleteNode(ListNode node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        DeletingNodeInSLL deletingNodeInSLL = new DeletingNodeInSLL();
        deletingNodeInSLL.insertFirst(-99);
        deletingNodeInSLL.insertFirst(5);
        deletingNodeInSLL.insertFirst(-3);
        deletingNodeInSLL.display();
        ListNode node = new ListNode(-3);
        deletingNodeInSLL.deleteNode(node);
        deletingNodeInSLL.display();
    }
}


/*

Your answer
Line 11: error: incompatible types: ListNode cannot be converted to Solution.ListNode [in __Driver__.java]
            node
            ^
 */
