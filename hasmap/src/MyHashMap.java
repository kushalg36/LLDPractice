class MyHashMap<K,V> {
    private static final int INITIAL_SIZE = 1 << 4; // 16
    private static final int MAX_CAPACITY = 1 << 30;

    public Entry[] hashTable;

    public MyHashMap() {
        int tableSize = tableSize(INITIAL_SIZE);
        hashTable = new Entry[tableSize];
    }

    public MyHashMap(int cap) {
        int tableSize = tableSize(MAX_CAPACITY);
        hashTable = new Entry[tableSize];
    }

    final int tableSize(int capacity) {
        int n = capacity - 1; /// to unset the most significant bit
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAX_CAPACITY) ? MAX_CAPACITY : n + 1; // n+1 to undo line 18
    }

    class Entry<K,V> {
        public K key;
        public V value;
        public Entry<K,V> next;

        public Entry(K k, V v) {
            key = k;
            value = v;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];
        if(node == null) {
            Entry newNode = new Entry(key, value);
            hashTable[hashCode] = newNode;
        } else {
            Entry previousNode = new Entry(key, value);
            while(node != null) {
                if(node.key == key) {
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            Entry newNode = new Entry(key, value);
            previousNode.next = newNode;
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        while(node != null) {
            if(node.key == key) {
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }
    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
        hashMap.put(1,  "hi1");
        hashMap.put(2,  "hi2");
        hashMap.put(3,  "hi3");
        hashMap.put(4,  "hi4");
        hashMap.put(5,  "hi5");
        hashMap.put(6,  "hi6");

        String value = hashMap.get(4);
        System.out.println(value);
    }
}