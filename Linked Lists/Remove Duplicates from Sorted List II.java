// Link to problem - https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

/**
 * Intuition - Use prev node to point to the last unique element.
 * When starting out, prev is pointing to a dummy node to handle edge cases
 * where head and its subsequent nodes are the same.
 * Find all duplicates in a sequence and then asssign prev.next to curr.next
 * to delete all duplicates in the middle.
 * Advance prev only if no duplicate sequence was found. Otherwise, if it is
 * advanced after a duplicate sequence, then there is a chance that the next
 * node after sequence is not unique and we won't be able to delete as we lost
 * the pointer to last unique element.
 *
 * Test cases - 
 * [1]
 * [1,1,1,2,3]
 * [1,1]
 * [1,1,1,3]
 * [1,1,1,2,2]
 * [1,1,2,2,3,3,4,4]
 * [1,1,2,2,3,3,4,4,5]
 * [0,1,1,2,2,3,3,4,4]
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        // Dummy node to handle edge case where head is not unique
        ListNode dummy = new ListNode(-1000);
        dummy.next = head;
        head = dummy;

        ListNode prev = dummy;
        ListNode curr = dummy.next;

        while(curr != null && curr.next != null) {
            // Iterate through all duplicates
            if(curr.val == curr.next.val) {
                while(curr != null && curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next = curr.next;
            }
            else {
                // Move prev to next node only when curr is unique - [1,1,2,2]
                prev = curr;
            }
            curr = curr.next;
        }

        return head.next;
    }
}
