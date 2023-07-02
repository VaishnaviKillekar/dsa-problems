// Link to problem - https://leetcode.com/problems/remove-duplicates-from-sorted-list/

/**
 * Intuition - Iterate through list and check for duplicate sequences.
 * When a sequence is found, iterate until the next unique element is found
 * and delete the duplicates nodes by updating the next pointer of first node
 * in sequence to the unique node found.
 * 
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while(curr != null && curr.next != null) {
            // Iterate through all duplicates
            if(curr.val == curr.next.val) {
                ListNode iter = curr;
                while(iter != null && iter.next != null && iter.val == iter.next.val) {
                    iter = iter.next;
                }
                curr.next = iter.next; 
            }
            curr = curr.next;
        }

        return head;
    }
}
