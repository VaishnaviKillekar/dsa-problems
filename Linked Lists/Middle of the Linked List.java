// Link to problem - https://leetcode.com/problems/middle-of-the-linked-list/

/**
 * Intuition - Flyod's Cycle Detection Algorithm
 * We use two pointers - 'fast' and 'slow'. The 'fast' pointer jumps two nodes while the
 * 'slow' pointer jumps one node. The iteration is carried out until 'fast' itself or its
 * next node is not null.
 * When loop terminates, fast has reached the end of list in case of odd number of nodes
 * and gone beyond the end in case of even nodes. 'slow' pointer points to the middle
 * node as needed.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}


/**
 * Intuition - Recursive approach 
 * Recurse through the list until the end is reached while incrementing a counter for each node.
 * Once the end is reached, the recursive calls are backtracked while decrementing the counter.
 * When the middle node is reached, it is saved into a variable.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    
    ListNode midNode = null;
    int count = 0;
    int mid = -1;
    
    public ListNode middleNode(ListNode head) {
        findMid(head);
        return midNode;
    }
    
    public void findMid(ListNode curr) {
        if(curr != null) {
            count++;
            findMid(curr.next);
            count--;
            if(count == mid) {
                midNode = curr;
            }
        }
        else {
            mid = (count % 2) == 0 ? (count + 1) / 2 : count / 2;
        }
    }
}
