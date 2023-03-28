// Link to problem - https://leetcode.com/problems/lru-cache/description/

/**
 * Intuition - Concise approach using LinkedHashMap
 * Override LinkedHashMap's removeEldestEntry() method to remove the least
 * recently used entry when there is an overflow.
 * This method will internally take care of removing LRU key.
 *
 * Time complexity - O(1)
 * Space complexity - O(n)
 */
import java.util.LinkedHashMap;

public class LRUCache {
  
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
  
    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
  
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
  
    public void set(int key, int value) {
        map.put(key, value);
    }
}
