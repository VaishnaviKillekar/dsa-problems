// Link to problem - https://leetcode.com/problems/min-stack/

/**
 * Intuition - Use a custom Linked List where the current lowest value is stored
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
