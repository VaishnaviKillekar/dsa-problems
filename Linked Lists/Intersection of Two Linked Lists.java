// Link to problem - https://leetcode.com/problems/intersection-of-two-linked-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;
        ListNode curr = null;
        
        if(headA == null || headB == null) {
            return null;
        }
        
        // Count no. of nodes in List A
        curr = headA;
        while(curr != null) {
            countA++;
            curr = curr.next;
        }
        
        // Count no. of nodes in List B
        curr = headB;
        while(curr != null) {
            countB++;
            curr = curr.next;
        }
        
        if(countA > countB) {
            curr = headA;
            while(countA != countB) {
                curr = curr.next;
                countA--;
            }
            headA = curr;
        }
        else if(countB > countA) {
            curr = headB;
            while(countB != countA) {
                curr = curr.next;
                countB--;
            }
            headB = curr;
        }
        
        while(headA != null && headB != null && !headA.equals(headB)) {
            headA = headA.next;
            headB = headB.next;
        }
        
        if(headA == null || headB == null) {
            return null;
        }
        
        return headA;
    }
}