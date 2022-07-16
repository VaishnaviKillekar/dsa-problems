// Link to problem - https://leetcode.com/problems/swap-nodes-in-pairs/

/**
 * Intuition - Swap the values of the adjacent nodes and jump the 'curr'
 * position by two nodes.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        
        while(curr != null && curr.next != null) {
            int t = curr.val;
            curr.val = curr.next.val;
            curr.next.val = t;
            curr = curr.next.next;
        }
        
        return head;
    }
}
