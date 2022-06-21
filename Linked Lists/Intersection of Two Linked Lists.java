// Link to problem - https://leetcode.com/problems/intersection-of-two-linked-lists/

/**
 * Intuition - Iterate through the lists using two pointers. Once the end of the list is reached, the pointers are
 * switched to the other list. This way, the pointers will eventually meet at the intersecting node.
 *
 * Time complexity - O(m + n)
 * Space complexity - O(1)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        
        while(a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}

/**
 * Intuition - Count the number of nodes in both lists. The list which contains more nodes, its pointer should
 * be moved those many positions ahead such that both lists are the same distance from the intersecting node.
 * Now move pointers of both list one position at a time and compare if the nodes are equal.
 * When they are equal, that is returned as the intersecting node.
 *
 * Time complexity - O(m + n) + O(n) [Count nodes in both lists, move pointers until they intersect, which could be last node]
 * Space complexity - O(1)
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
