package main.java;

import java.util.LinkedHashMap;
import java.util.Map;

// The cache has a capacity
// If the cache is full and another entry is added, the LRU entry is dropped (the tail of the list).
// When an item is added, and every time it is accessed after that it is automatically moved to the head
public class GoogleLC146LRUCache {
    // http://chriswu.me/blog/a-lru-cache-in-10-lines-of-java/
    // query the least recently used item, and remove it if reached capacity
    // add and remove operations
    // considering as well removing the head item (capacity is 1), the tail item
    // LinkedMap is a subset of HashMap that by default the iteration order reflects the order the entries are added to the map.
    // LinkedHashMap has an option to use access-order instead of insertion order,
    // and includes a way to remove the least-recently accessed entries automatically.
    // Also need to mark an item as MRU

    // LinkedList allows for query LRU(just return the tail)
    // and mark MRU(remove it from its current position and move it to the head)
    // Also need to find this item quickly in the linked list - Hash Table to the rescue
    private LinkedHashMap<Integer, Integer> map;
    private int capacity;

    // Creates a LRU cache.
    public GoogleLC146LRUCache(int capacity) {
        this.capacity = capacity;
        //public LinkedHashMap(int initialCapacity,
        //float loadFactor,
        //boolean accessOrder)
        //accessOrder: true for access-order, false for insertion-order
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            // remove the oldest entry
            // returns true when the cache has more entries than our defined capacity
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return map.size() > GoogleLC146LRUCache.this.capacity;
            }
        };
    }

    // Retrieves an entry from the cache.
    // The retrieved entry becomes the MRU (most recently used) entry.
    // After looking up the item, we can move it to the front of the linked list.
    public int get(int key) {
        Integer rtn = map.get(key);
        return rtn == null ? -1:rtn;
    }

    // Adds an entry to this cache.
    // The new entry becomes the MSU (most recently used) entry
    // If an entry with the specified key already exists, it is replaced by the new entry
    // If the cache is full, the LRU entry is removed from the cache
    public void set(int key, int value) {
        map.put(key, value);

    }

    public void printAll() {
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.print(e.getKey() + " : " + e.getValue() + "\t");
        }
        System.out.println();
    }

    // Test routine for the LRUCache class.
    public static void main (String[] args) {
        GoogleLC146LRUCache c = new GoogleLC146LRUCache(3);

        c.set (1, 12);
        c.printAll();

        c.set (2, 22);
        c.printAll();

        c.set (3, 35);
        c.printAll();

        c.set (4, 67);
        c.printAll();

        if (c.get(2) != 22) throw new Error();
        c.printAll();

        c.set (5, 5);
        c.printAll();

        c.set (4, 78);
        c.printAll();

        // Verify cache content.
        if (c.get(4) != 78)         throw new Error();
        c.printAll();

        if (c.get(5) != 5)          throw new Error();
        c.printAll();

        if (c.get(2) != 22)         throw new Error();
        c.printAll();

        c.set (6, 98);
        c.printAll();
    }
}
