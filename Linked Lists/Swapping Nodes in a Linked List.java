// Link to problem - https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

/**
 * Intuition - Two pointer approach
 * The first kth node can be found while moving the 'fast' pointer ahead by k positions
 * to maintain a gap between the 'fast' and 'slow' pointers.
 * This gap helps find the kth node from the end.
 * 
 * On creating the required gap, advance both pointers at same speed until 'fast' is null.
 * Once 'fast' is null, 'slow' pointer reaches the kth node from end.
 * Swap the values of the first and last kth node.
 * 
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = null;
        ListNode start = new ListNode(-1, head);
        ListNode slow = start;
        ListNode fast = start;
        
        // Find the kth node from beginning and move fast pointer k positions ahead
        for(int i = 0; i < k; i++) {
            fast = fast.next;
        }
        first = fast;
        
        // Advance both pointers maintaining the gap
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Swap the nodes using their previous nodes
        int t = slow.val;
        slow.val = first.val;
        first.val = t;
        
        return head;
    }
}
