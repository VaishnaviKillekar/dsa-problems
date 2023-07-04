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
        ListNode fast = head;
        ListNode slow = head;

        // Find midpoint of list
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse the list after slow node
        ListNode prev = slow;
        ListNode curr = slow.next;
        ListNode second = slow;     // head node of reverse list

        while(curr != null) {
            prev.next = curr.next;
            curr.next = second;
            second = curr;
            curr = prev.next;
        }

        // Compare the first half and reverse
        while(head != slow) {
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
