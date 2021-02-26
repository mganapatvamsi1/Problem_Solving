public class MaxPQ {

    Integer[] heap;
    int n;

    public MaxPQ(int capacity) {
        heap = new Integer[capacity + 1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void resize(int storage) {
        Integer[] temp = new Integer[storage];
        for (int i = 0; i < heap.length; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public void insert(int value) {
        if (n == heap.length - 1) {
            resize(2 * heap.length);
        }
        n++;
        heap[n] = value;
        heapifyUp(n);
    }

    //TODO: deleting from a max heap
    //TODO: getting an element from max Heap
    //TODO: insert, delete and get an element from minHeap

    private void heapifyUp(int k) {
        while (k > 1 && heap[k/2] < heap[k]) {
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k = k/2;
        }
    }

    public void printMaxHeap() {
        for (int i = 1; i <= n; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ(3);
        System.out.println(pq.size()); // 0
        System.out.println(pq.isEmpty()); // true

        pq.insert(4);
        pq.insert(5);
        pq.insert(2);
        pq.insert(6);
        pq.insert(1);
        pq.insert(3);
        System.out.println(pq.size());
        pq.printMaxHeap();

    }
}
