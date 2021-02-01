package others.queues;


import java.util.NoSuchElementException;

public class QueueList {

    private QueueListNode front;
    private QueueListNode rear;
    private int length;

    public static class QueueListNode {
        private int data;
        private QueueListNode next;

        public QueueListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public QueueList() {
        front = null;
        rear = null;
        length = 0;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void print() {
        if (isEmpty()) {
            return;
        }
        QueueListNode current = front;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Adding elements into queue
    public void enqueue(int data) {
        QueueListNode temp = new QueueListNode(data);
        if (isEmpty()) {
            front = temp;
        } else {
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    // removing elements from queue
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int result = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        length--;
        return result;
    }

    // first (value stored by the first element)
    public int getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return front.data;
    }


    // last (value stored by the rear element)
    public int getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return rear.data;
    }

    public static void main(String[] args) {
        QueueList queue = new QueueList();
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);
        System.out.println(queue.getFirst());
        System.out.println(queue.getLast());
        queue.print();

        queue.dequeue();
        queue.dequeue();
        queue.print();

    }
}
