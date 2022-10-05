// Link to problem - https://leetcode.com/problems/delete-node-in-a-linked-list/

/**
 * Intuition - Replace the value of given node with its next node.
 * Now make the next of given node as next of its next node.
 * Make the original next as null.
 *
 * Time complexity - O(1)
 * Space complexity - O(1)
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        ListNode remove = node.next;
        remove = null;
        node.next = node.next.next;
    }
}

/**
 * Intuition - Replace the value of given node with value of its
 * next node. Continue this process until the end of list.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while(node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}
