// Link to problem - https://leetcode.com/problems/remove-nth-node-from-end-of-list/

/**
 * Intuition - Two pointer approach with dummy node
 * Use two pointers 'fast' and 'slow' such that the gap between them is n+1.
 * Gap is n+1 to get the previous node of nth.
 * 
 * Start with advancing the 'fast' pointer to point by (n+1) positions from 'start' node.
 * Once 'fast' pointer moves n+1 positions forward, advance both 'fast' and 'slow'
 * pointers at the same speed to maintain the n+1 gap until 'fast' becomes null.
 *
 * Once 'fast' becomes null, the 'slow' pointer would be pointing the previous of nth node.
 * Remove the nth node and return head.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    
        ListNode start = new ListNode(0, head);
        ListNode slow = start, fast = start;

        // Move fast in front so that the gap between slow and fast becomes n
        for(int i = 0; i <= n; i++)   {
            fast = fast.next;
        }

        // Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node
        slow.next = slow.next.next;
        return start.next;
    }
}

/**
 * Intuition - Two pointer approach without dummy node
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        
        int i = 1;
        while(fast != null && i <= n) {
            fast = fast.next;
            i++;
        }
        
        if(fast == null) {
            return slow.next;
        }
        
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        
        return head;
    }
}

/**
 * Intuition - Iterative approach
 * Iterate through the linked list and get its size. Compute the index of the node
 * previous to the node to be removed by using the size of the list and n.
 * If index of previous node is 0, then return head.next as node to be removed is head.
 *
 * Iterate through the list again while maintaining a counter initialized to 1
 * pointing to the head. Increment the counter while iterating through the list
 * until the counter reaches the index of previous node.
 * Use the 'curr' pointer to the previous nodes and remove the nth node.
 * 
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode curr = head;
        
        while(curr != null) {
            curr = curr.next;
            size++;
        }
        
        int prev = size - n;
        if(prev == 0) {
            return head.next;
        }
        
        int count = 1;
        curr = head;
        while(count < prev) {
            curr = curr.next;
            count++;
        }
        
        curr.next = curr.next.next;
        return head;
    }
}

/**
 * Intuition -  Recursive approach
 * Use recursion to iterate through the array until the last node is reached
 * while incrementing a counter 'length'.
 * On reaching the last node, the recursion starts backtracking while
 * incrementing a 'index' variable which starts counting from the last node.
 *  
 * Once the index matches the index of node previous to nth node, we store
 * its reference in 'nthPrev' and return.
 *
 * If 'nthPrev' is not null, remove the nth node and return head.
 * Else, nth node is head, return its next node.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
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
