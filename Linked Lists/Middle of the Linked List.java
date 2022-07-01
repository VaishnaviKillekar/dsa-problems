// Link to problem - https://leetcode.com/problems/middle-of-the-linked-list/


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
