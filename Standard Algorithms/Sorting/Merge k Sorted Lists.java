// Link to problem - https://leetcode.com/problems/merge-k-sorted-lists/description/

/**
 * Intuition - Since the k arrays are sorted, we use divide & conquer to further divide
 * the lists and start merging 2 lists at a time using merge sort.
 *
 * Time complexity - O(nlogn)
 * Space complexity - O(k) - depth of recursion tree. No additional arrays used
 *
 * NOTE: This problem is also solved using heap.
 *
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    public ListNode partition(ListNode[] lists, int start, int end) {
        if(start > end) {
            return null;
        }
        else if(start == end) {
            return lists[start];
        }
        else {
            int mid = (start + end) / 2;
            ListNode first = partition(lists, start, mid);
            ListNode second = partition(lists, mid + 1, end);
            return merge(first, second);
        }
    }

    public ListNode merge(ListNode first, ListNode second) {
        ListNode head = new ListNode(-1);   // Dummy head;
        ListNode curr = head;
        
        while(first != null && second != null) {
            ListNode node = null;
            if(first.val < second.val) {
                node = first;
                first = first.next;
            }
            else {
                node = second;
                second = second.next;
            }
            curr.next = node;
            node.next = null;
            curr = curr.next;
        }
        if(first != null) {
            curr.next = first;
        }
        if(second != null) {
            curr.next = second;
        }
        
        return head.next;
    }
}
