// Link to problem - https://leetcode.com/problems/sort-list/description/

/**
 * Intuition - Merge Sort
 *
 * Time complexity - O(nlogn)
 * Space complexity - O(logn) - maximum height of recursion tree in merge sort
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = head;
        ListNode right = mid.next;

        // Split the lists
        mid.next = null;

        // Split the halves to sort
        left = sortList(left);
        right = sortList(right);

        // Merge both sorted halves
        return merge(left, right);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null) {
            curr.next = l1;
        }
        if(l2 != null) {
            curr.next = l2;
        }

        return head.next;
    }

    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
