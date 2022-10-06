// Link to problem - https://leetcode.com/problems/palindrome-linked-list/

/**
 * Intuition - Reverse second half of list and compare
 * Use 'slow' and 'fast' pointers to find the middle of list.
 * Based on the size of list, assign the 'second' pointer to
 * point to the start of second list.
 *  Now, reverse the second list and compare both lists.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode second = null;
        
        if(head.next == null) {
            return true;
        }
        
        // Find the midpoint of list
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Check if list size is odd or even
        if(fast.next != null) {     // even
            second = slow.next;
        }
        else {
            second = slow.next;
            slow = null;
        }
        
        // Reverse the second part of list
        ListNode curr = second;
        while(curr.next != null) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = second;
            second = next;
            next = curr.next;
        }
        
        // Compare the nodes in both lists
        while(second != null) {
            if(head.val != second.val) {
                return false;
            }
            head = head.next;
            second = second.next;
        }
        
        return true;
    }
}



/**
 * Intuition - Use recursion and compare nodes while backtracking
 * Recursively call the compare() until the end of list is reached. During each
 * recursive call, count the nodes in the list. While backtracking, incremement
 * the 'mid' counter which is used to determine if backtracking has reached the
 * middle of list. During each backtracking, compare the current node with the 
 * node from start, which is tracked via 'start'.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    int length = 0;
    int mid = -1;
    boolean palindrome = true;
    ListNode start;
    
    public boolean isPalindrome(ListNode head) {
        start = head;
        compare(head);
        return palindrome;
    }
    
    public void compare(ListNode curr) {
        // count the node to get length of linked list
        if(curr != null) {
            length++;
            compare(curr.next);      
        }
        else {
            return;
        }
        mid++;
        length--;
        // compare if the mirror nodes are equal
        if(palindrome && mid < length) {
            if(curr.val == start.val) {
                start = start.next;                
            }
            else {
                palindrome = false;
            }
        }
    }
}
