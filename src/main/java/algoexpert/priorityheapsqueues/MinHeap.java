package algoexpert.priorityheapsqueues;

//TODO: To check this later
//TODO: https://stackoverflow.com/questions/28819327/time-complexity-of-inserting-in-to-a-heap
//TODO: https://stackoverflow.com/questions/11644987/time-complexity-to-get-min-elements-from-max-heap
// Time complexity is inserting and deleting in worst case in a maxHeap is O(LogN) where as
// for searching an element worst case is O(N)
// finding max element worst case is O(1)

public class MinHeap {

    int[] heap;
    int heapSize; // size of minHeap
    public MinHeap(int capacity) {
        heap = new int[capacity + 1];
        heapSize = 0;
    }

    public boolean isEmpty() { return heapSize == 0; }

    public int size() { return heapSize; }

    public void resize(int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < heap.length; i++) temp[i] = heap[i];
//        System.arraycopy(heap, 0, temp, 0, heap.length);
        heap = temp;
    }

    public void printMinHeap() {
        for (int i = 1; i <= heapSize; i++) System.out.print(heap[i] + "  ");
        System.out.println();
    }

    public void insert(int value) {
        if (heapSize == heap.length - 1) resize(2 * heap.length);
        heapSize++;
        heap[heapSize] = value;
        shiftDown(heapSize);
    }

    // also called as TopDown Reheapify
    public void shiftDown(int index) {
        while (index > 1 && heap[index/2] > heap[index]) {
            int temp = heap[index];
            heap[index] = heap[index/2];
            heap[index/2] = temp;
            index = index/2;
            // because we need to continue shifting down until new value is inserted at correct position.
        }
    }

    // deleting an element from minHeap
    public int deleteMin() {
        int temp = heap[1]; // initial min heap
        int lastElement = heap[heapSize]; // get the last element
        heap[1] = lastElement; // replace root with last element
        heapSize = heapSize - 1; // decrease size of the heap by 1
        heapify(heapSize, 1); // heapify the root value
        return temp;
    }

    private void heapify(int size, int rootIndex) {
        int minElementIndex = rootIndex;
        int leftNodeIndex = 2 * minElementIndex; // left subtree
        int rightNodeIndex = 2 * minElementIndex + 1; // right subtree
        // if left child is smaller than root index
        if (leftNodeIndex < size && heap[leftNodeIndex] < heap[minElementIndex]) minElementIndex = leftNodeIndex;
        if (rightNodeIndex < size && heap[rightNodeIndex] < heap[minElementIndex]) minElementIndex = rightNodeIndex;
        // if smallest element is not root
        if (minElementIndex != rootIndex) {
            int temp = heap[rootIndex];
            heap[rootIndex] = heap[minElementIndex];
            heap[minElementIndex] = temp;
            // recursively heapify the affected subtree
            heapify(heapSize, minElementIndex);
        }
    }

    public int getMin() { return heap[1]; }

    public static void main(String[] args) {
        MinHeap minHeapPQ = new MinHeap(3);
        minHeapPQ.insert(4);
        minHeapPQ.insert(5);
        minHeapPQ.insert(2);
        System.out.println(minHeapPQ.size()); // 3
        minHeapPQ.printMinHeap(); //
        minHeapPQ.insert(1);
        minHeapPQ.insert(6);
        minHeapPQ.printMinHeap(); //
        minHeapPQ.insert(9);
        minHeapPQ.printMinHeap(); //
        minHeapPQ.insert(11);
        System.out.println(minHeapPQ.size()); // 7
        System.out.println(minHeapPQ.isEmpty()); // false
        System.out.println("minElement: "+minHeapPQ.getMin()); //
        minHeapPQ.printMinHeap(); //

        System.out.println(minHeapPQ.deleteMin()); //
        System.out.println("minElement: "+minHeapPQ.getMin()); //
        minHeapPQ.printMinHeap(); //
        System.out.println(minHeapPQ.deleteMin()); //
        System.out.println("minElement: "+minHeapPQ.getMin()); //
        minHeapPQ.printMinHeap(); //
        System.out.println(minHeapPQ.deleteMin()); //
        System.out.println("minElement: "+minHeapPQ.getMin()); //
        minHeapPQ.printMinHeap(); //
        System.out.println(minHeapPQ.deleteMin()); //
        System.out.println("minElement: "+minHeapPQ.getMin()); //
        minHeapPQ.printMinHeap(); //
    }
}
