// Link to problem - https://leetcode.com/problems/lru-cache/description/

/**
 * Intuition - Regular approach using HashMap and Doubly Linked List
 * Store the keys and their respective values in a Double LinkedList 'Node'.
 * Use a dummy head and tail which initially will be the only nodes in the list.
 * On every put, add a new node at the start of list to the right of head. Also,
 * add an entry to the map where the value contains the pointer to the node in list.
 * If the map capacity is reached, remove the node previous to tail as it is least
 * recently used.
 * For every get, move the node to right of head, if found. This tracks its usage.
 *
 * Time complexity - O(1)
 * Space complexity - O(n)
 */
class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node() {}

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node != null) {
            // Move the node to the front of list, next to head as it's used
            removeNode(node);
            Node updatedNode = addNode(node.key, node.val);
            map.put(key, updatedNode);
            return updatedNode.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // Check if key already exists - update it and move next to head
        if(map.get(key) != null) {
            removeNode(map.get(key));
        }

        // New key - check if cache is at max capacity
        else if(map.size() == capacity) {
            // Find LRU key and evict - node prior to tail
            map.remove(tail.prev.key);
            removeNode(tail.prev);
        }

        // Add new node next to head
        Node node = addNode(key, value);
        map.put(key, node);
    }

    public Node addNode(int key, int value) {
        // Add new node next to head
        Node node = new Node(key, value);
        
        Node second = head.next;
        second.prev = node;
        head.next = node;
        node.prev = head;
        node.next = second;

        return node;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}



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
