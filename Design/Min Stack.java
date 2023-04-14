// Link to problem - https://leetcode.com/problems/min-stack/

/**
 * Intuition - With dummy node - tail
 * Design a custom linked list which has both 'prev' and 'next' pointers, 'val'
 * and an extra field 'min' which stores the lowest value encountered so far.
 *
 * While push, compare the 'min' of current tail (last pushed element) with 'val'
 * of current element to be pushed and store the minimum in the new tail's 'min'.
 *
 * Time complexity - O(1)
 * Space complexity - O(n)
 */
class MinStack {

    class Node {
        int val;
        Node prev;
        Node next;
        int min;

        public Node(int val) {
            this.val = val;
        }
    }

    Node tail;

    public MinStack() {
        tail = new Node(0);
        tail.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        Node node = new Node(val);
        node.next = tail;
        node.min = Math.min(val, tail.min);
        tail.prev = node;
        tail = node;
    }
    
    public void pop() {
        tail = tail.next;
        tail.prev = null;
    }
    
    public int top() {
        return tail.val;
    }
    
    public int getMin() {
        return tail.min;
    }
}


/**
 * Intuition - Without Dummy Node
 * Use a custom Linked List where the current lowest value is stored
 * at each node including previous and next pointers.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class MinStack {

    class ListNode {
        int val;
        ListNode prev;
        ListNode next;
        int lowSoFar;
        
        public ListNode(int val) {
            this.val = val;
            prev = null;
            next = null;
            lowSoFar = Integer.MAX_VALUE;
        }
    }
    
    ListNode stack;
    ListNode tail;
    
    public MinStack() {
        stack = null;
        tail = null;
    }
    
    public void push(int val) {
        ListNode node = new ListNode(val);
        node.prev = tail;
        node.next = null;
        // Current node is lowest or the first node
        if((node.prev != null && node.val < node.prev.lowSoFar) || node.prev == null) {
            node.lowSoFar = node.val;
        }
        // This is not the first node and not the lowest
        else {
            node.lowSoFar = node.prev.lowSoFar;
        }
        // Link previous node with current node
        if(tail != null) {
            tail.next = node;            
        }
        tail = node;
    }
    
    public void pop() {
        ListNode top = tail;
        tail = tail.prev;
        top = null;
    }
    
    public int top() {
        return tail.val;
    }
    
    public int getMin() {
        return tail.lowSoFar;
    }
}
