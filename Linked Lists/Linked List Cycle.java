// Link to problem - https://leetcode.com/problems/linked-list-cycle/

/**
 * Intuition - Use a fast and slow pointer to find the cycle.
 * If there's a cycle, then the fast and slow pointer meet at a node.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
