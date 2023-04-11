// Link to problem - https://leetcode.com/problems/sort-list/description/

/**
 * Intuition - Merge Sort
 * Find the mid of the list using the fast-slow pointer technique. Split the list
 * using mid such that mid becomes a part of the right list. Hence, maintain a node
 * 'slowPrev' to track the previous node of slow pointer and make its next as null to split lists.
 * Then merge the left and right lists using Merge Sort.
 *
 * Time complexity - O(logn)
 * Space complexity - O(logn)
 */
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while(left != null && right != null) {
            if(left.val < right.val) {
                tail.next = left;
                left = left.next;
            }
            else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        tail.next = (left != null) ? left : right;
        return dummyHead.next;
    }

    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPrev = null;

        while(fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slowPrev != null) {
            // Split the lists so that mid becomes part of right list
            slowPrev.next = null;
        }
        return slow;
    }
}
