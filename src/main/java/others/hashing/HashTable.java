package others.hashing;

public class HashTable {

    private HashNode[] buckets;
    private int numOfBuckets; // capacity
    private int size; // no of key-value pairs or HashNodes in the HashTable

    private class HashNode {
        private int key; // can be generic
        private String value; // can be generic
        private HashNode next; // reference to the next element

        public HashNode(int k, String v) {
            this.key = k;
            this.value = v;
            this.next = null;
        }
    }

    public HashTable() {
        this(10);
    }

    public HashTable(int capacity) {
        this.numOfBuckets = capacity;
        buckets = new HashNode[numOfBuckets];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void put(Integer key, String value) {

    }

    // this method takes in a key and returns the corresponding associated element
    public String get(Integer key) {
        return null;
    }

    // the corresponding key-value pair will be completely removed from the HashTable and returns its corresponding value
    public String remove(Integer key) {
        return null;
    }

    // The average time complexity for all these inserting, retrieving and remove an element from
    // a HashTable are O(1)

    public static void main(String[] args) {

    }
}
