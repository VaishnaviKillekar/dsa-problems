// Link to problem - https://leetcode.com/problems/merge-k-sorted-lists/

/**
 * Intuition - Add the head nodes of all lists into a min heap. Now poll the heap
 * to get the minimum node and add it to the result list. Get the next node of polled
 * node and reset next pointer of polled node. Add the next node to heap and continue
 * this process until heap is empty to get sorted list of lists.
 *
 * Priority Queue time complexity:
 * Add - O(logn)
 * Poll, Peek - O(logn)
 * Remove specific - O(n)
 *
 * Time complexity - O(n*klog(n*k))
 * Space complexity - O(n*k)
 */
class Solution {
    // Custom Comparator for ListNode objects to act as a min heap
    public class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode a, ListNode b) {
            if(a.val < b.val) {
                return -1;
            }
            else if(a.val == b.val) {
                return 0;
            }
            return 1;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // Dummy head node which will point to result
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        
        // Maintain a min heap of size k
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new ListNodeComparator());
        
        // Add all the head nodes to min heap
        for(int i = 0; i < lists.length; i++) {
            // Ignore empty lists
            if(lists[i] != null) {
                minHeap.add(lists[i]);
            }
        }

        // Pop minimum node from the min heap and add that to result list
        // On popping a node, add that node's next node to heap
        while(minHeap.size() > 0) {
            ListNode lowest = minHeap.poll();
            ListNode next = lowest.next;
            lowest.next = null;
            curr.next = lowest;
            curr = curr.next;
            if(next != null) {
                minHeap.add(next);
            }
        }

        return head.next;
    }
}
