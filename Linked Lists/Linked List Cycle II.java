// Link to problem - https://leetcode.com/problems/linked-list-cycle-ii/

/**
 * Intuition - FLyod's Cycle Detection algorithm
 * Use fast and slow pointers to detect if the list contains a cycle.
 * If there's a cycle, then reset the slow pointer to head and advance both
 * fast and slow pointers by one node at a time until fast.next is not slow.
 *
 * Time complexity - O(n)
 * Space complexity - O()
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // List has no cycle as there is a node with a next pointer as null
        if(fast == null || fast.next == null) {
            return null;
        }

        // List has a cycle as fast met slow
        slow = head;
        while(fast.next != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
