// Link to problem - https://leetcode.com/problems/reverse-linked-list-ii/solution/

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp;
        ListNode curr;
        ListNode psuedo = null;
        
        if(left == 1) {
            psuedo = new ListNode(-1);
            psuedo.next = head;
            head = psuedo;
        }
        ListNode ref = head;
        
        for(int i = 1; i < left - 1; i++) {
            ref = ref.next;
        }
        curr = ref.next;
        
        while(curr != null && left < right) {
            temp = curr.next;
            curr.next = temp.next;
            temp.next = ref.next;
            ref.next = temp;
            left++;
        }
        
        if(psuedo != null) {
            head = psuedo.next;
        }
        return head;
    }
}