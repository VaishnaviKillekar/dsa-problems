// Link to problem - https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/

/**
 * Intuition - Recursion 
 * Iterate through each node and recursively call the function again for every child.
 *
 * Time complexity - O(n^2) - we iterate through all nodes next to each other and then through child nodes. 
 *                            Then we iterate through children again to find tail. Worst case, each node has child nodes and finding tail could cost n. Confirm?
 * Space complexity - O(n) - maximum height of recursion tree when list has only child nodes
 */
class Solution {
    public Node flatten(Node head) {
        if(head == null) {
            return head;
        }
        
        Node curr = head;
        Node prev = curr.prev;
        Node next = curr.next;

        while(curr != null) {
            if(curr.child != null) {
                Node child = flatten(curr.child);
                // Get the last node of the child list
                while(child.next != null) {
                    child = child.next;
                }
                Node tail = child;
                curr.next = curr.child;
                curr.child.prev = curr;
                tail.next = next;
                if(next != null) {
                    next.prev = tail;
                }
                curr.child = null;
            }
            // Move to next node
            prev = next != null ? next.prev : curr;
            curr = next;
            next = next != null ? next.next : null;
        }

        return head;
    }
}
