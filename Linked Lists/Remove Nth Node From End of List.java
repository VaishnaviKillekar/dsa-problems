// Link to problem - https://leetcode.com/problems/remove-nth-node-from-end-of-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    ListNode nthPrev = null;
    int length = 0;
    int index = 0;
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }
        
        getPreviousOfNth(head, n);
        
        if(nthPrev != null) {
            nthPrev.next = nthPrev.next.next;
        }
        else {
            head = head.next;
        }
        return head;
    }
    
    public void getPreviousOfNth(ListNode curr, int n) {
        length++;
        if(curr.next != null) {
            getPreviousOfNth(curr.next, n);
        }
        index++;
        if(index - 1 == n) {
            nthPrev = curr;
        }
    }
}