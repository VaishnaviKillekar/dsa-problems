/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        
        if(head == null || head.next == null) {
            return null;
        }
        
        while(fast != null && fast.next != null && !fast.equals(slow)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast != null && fast.equals(slow)) {
            return slow.next;
        }
        return null;
    }
}