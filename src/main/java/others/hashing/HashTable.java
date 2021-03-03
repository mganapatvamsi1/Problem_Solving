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

    // using modular hashing function
    public int getBucketIndex(Integer key) {
        return key % numOfBuckets; // buckets.length
    }

    public void put(Integer key, String value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or value is null");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[bucketIndex]; // to make head reach to the first location
        HashNode node = new HashNode(key, value);
        node.next = head; // trying to insert the new node if any, at the beginning of the node
        buckets[bucketIndex] = node;
    }

    // this method takes in a key and returns the corresponding associated element
    public String get(Integer key) {
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    // the corresponding key-value pair will be completely removed from the HashTable and returns its corresponding value
    public String remove(Integer key) {
        return null;
    }

    // The average time complexity for all these inserting, retrieving and remove an element from
    // a HashTable are O(1)

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.put(105, "Tom");
        hashTable.put(21, "Sana");
        hashTable.put(21, "Raj");
        hashTable.put(21, "Aryan");
        hashTable.put(31, "Malhotra");
        System.out.println(hashTable.getSize());

    }
}
