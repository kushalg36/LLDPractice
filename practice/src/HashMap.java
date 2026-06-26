public class HashMap<K, V> {

    static int INIT_SIZE = 1 << 4; // 16
    static int MAX_SIZE = 1 << 30; // 16
    class Entry<K, V> {
        K key;
        V value;
        public Entry<K,V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        if(node == null) {
            Entry newNode = new Entry(key, value);
            hashTable[hashCode] = newNode;
        } else {
            Entry prevNode = node;

            while(node != null) {
                if(node.key == key) {
                    node.value = value;
                    return;
                }
                prevNode = node;
                node = node.next;
            }
            Entry newNode = new Entry<>(key, value);
            prevNode.next = newNode;
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        while(node != null) {
            if(node.key.equals(key)) {
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }

    Entry[] hashTable;

    public HashMap()  {
        hashTable = new Entry[1 << 4];
    }

    public HashMap(int size) {
        int tableSize = tableSizeFor(size);
        hashTable = new Entry[tableSize];
    }

    public int tableSizeFor(int size) {
        int n = size-1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n<0) ? 1 : (n >= MAX_SIZE) ? MAX_SIZE : n+1;
    }

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
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