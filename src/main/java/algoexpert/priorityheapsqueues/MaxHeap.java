package algoexpert.priorityheapsqueues;

//TODO: To check this later
//TODO: https://stackoverflow.com/questions/28819327/time-complexity-of-inserting-in-to-a-heap
//TODO: https://stackoverflow.com/questions/11644987/time-complexity-to-get-min-elements-from-max-heap
// Time complexity is inserting and deleting in worst case in a maxHeap is O(LogN) where as
// for searching an element worst case is O(N)
// finding max element worst case is O(1)

public class MaxHeap {

    int[] heap;
    int heapSize; // size of the maxHeap
    public MaxHeap(int capacity) {
        heap = new int[capacity + 1]; // index 0 is kept as empty
        heapSize = 0;
    }

    public boolean isEmpty() { return heapSize == 0; }

    public int size() { return heapSize; }

    public void resize(int capacity) {
        int[] temp = new int[capacity];
        //        System.arraycopy(heap, 0, temp, 0, heap.length);
        for (int i = 0; i < heap.length; i++) temp[i] = heap[i];
        heap = temp;
    }

    public void printMaxHeap() {
        for (int i = 1; i <= heapSize; i++) System.out.print(heap[i] + " ");
        System.out.println();
    }

    public void insert(int value) {
        if (heapSize == heap.length - 1) { resize(2 * heap.length);}
        heapSize++;
        heap[heapSize] = value;
        shiftUp(heapSize);
    }

    // Also called as BottomUp Reheapify
    public void shiftUp(int index) {
        while (index > 1 && heap[index/2] < heap[index]) {
            int temp = heap[index];
            heap[index] = heap[index/2];
            heap[index/2] = temp;
            index = index/2; // because we need to continue shifting up
            // till new value inserted is at correct position.
        }
    }

    // deleting an element from maxHeap
    public int deleteMax() {
        int temp = heap[1]; // initial max heap
        int lastElement = heap[heapSize]; // get the last element
        heap[1] = lastElement; // replace root with last element
        heapSize = heapSize - 1; // decrease size of heap by 1
        heapify(heapSize, 1); // heapify the root node
        return temp;
    }

    private void heapify(int size, int rootIndex) {
        int maxElementIndex = rootIndex;
        int leftNodeIndex = 2 * rootIndex; // left subtree
        int rightNodeIndex = 2 * rootIndex + 1; // right subtree
        // if left child is larger than root
        if (leftNodeIndex < size && heap[leftNodeIndex] > heap[maxElementIndex]) maxElementIndex = leftNodeIndex;
        // if right child is larger than root
        if (rightNodeIndex < size && heap[rightNodeIndex] > heap[maxElementIndex]) maxElementIndex = rightNodeIndex;
        // if largest is not root
        if (maxElementIndex != rootIndex) {
            int temp = heap[rootIndex];
            heap[rootIndex] = heap[maxElementIndex];
            heap[maxElementIndex] = temp;
            // recursively heapify the affected subtree
            heapify(heapSize, maxElementIndex);
        }
    }

    // getMax (find max element in the max heap) --> heap[1]
    public int getMax() {return heap[1];}

    public static void main(String[] args) {
        MaxHeap maxHeapPQ = new MaxHeap(3);
        maxHeapPQ.insert(4);
        maxHeapPQ.insert(5);
        maxHeapPQ.insert(2);
        System.out.println(maxHeapPQ.size()); // 3
        maxHeapPQ.printMaxHeap(); // 5 4 2
        maxHeapPQ.insert(1);
        maxHeapPQ.insert(6);
        maxHeapPQ.printMaxHeap(); // 6 5 2 1 4
        maxHeapPQ.insert(9);
        maxHeapPQ.printMaxHeap(); // 9 5 6 1 4 2
        maxHeapPQ.insert(11);
        System.out.println(maxHeapPQ.size()); // 7
        System.out.println(maxHeapPQ.isEmpty()); // false
        System.out.println("maxElement: "+maxHeapPQ.getMax()); // 11
        maxHeapPQ.printMaxHeap(); // 11 5 9 1 4 2 6

        System.out.println(maxHeapPQ.deleteMax()); // 11
        System.out.println("maxElement: "+maxHeapPQ.getMax()); // 9
        maxHeapPQ.printMaxHeap(); // 9 5 6 1 4 2
        System.out.println(maxHeapPQ.deleteMax()); // 9
        System.out.println("maxElement: "+maxHeapPQ.getMax()); // 6
        maxHeapPQ.printMaxHeap(); // 6 5 2 1 4
        System.out.println(maxHeapPQ.deleteMax()); // 6
        System.out.println("maxElement: "+maxHeapPQ.getMax()); // 5
        maxHeapPQ.printMaxHeap(); // 5 4 2 1
    }
}
