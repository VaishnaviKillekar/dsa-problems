// Link to problem - https://leetcode.com/problems/reverse-linked-list/

/**
 * Intuition - Recursive approach
 * Recursively call the `revrese()` function until the last element is reached. Record the last element.
 * Now when the recursive calls backtrack, the current nodes are returned as `prev` to the calling
 * function and the `next` pointers are reversed.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    ListNode start = null;
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        reverse(head);
        return start;
    }
    
    public ListNode reverse(ListNode curr) {
        if(curr.next != null) {
            ListNode prev = reverse(curr.next);
            prev.next = curr;
            curr.next = null;
        }
        else {
            start = curr;
        }
        return curr;
    }
}

/**
 * Intuition - Iterative approach
 * We use a 'curr' pointer which points to the current node that needs to move to the start
 * of the list and become the new head.
 * Iterate through the list starting from the second node so the original head can be the 
 * last nodeof the reversed list.
 * Move the current node to the start (or before current head) and advance the 'curr' pointer.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        
        if(head == null) {
            return head;
        }
        curr = curr.next;
        head.next = null;
        
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = head;
            head = curr;
            curr = next;
        }
        
        return head;
    }
}

/**
 * Intuition - Iterative approach
 * Two pointers `prev` and `curr` store the pointers to the previous and current elements.
 * Start with head as `prev`. While the `curr` pointer is not null, reverse the pointers
 * for these two elements. The move on to the next elements on the list.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public ListNode reverseList(ListNode head) {
               
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode curr = head.next;
        ListNode prev = head;
        
        while(curr != null) {
            prev.next = curr.next;
            curr.next = head;
            head = curr;
            curr = prev.next;
        }
        
        return head;
    }
}
