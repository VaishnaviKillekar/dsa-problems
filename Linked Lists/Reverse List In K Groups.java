// Link to problem - https://leetcode.com/problems/reverse-nodes-in-k-group/description/

/**
 * Intuition - Reverse linked list in k sections
 * Reverse the first k nodes of the list using iteration and then recursively call the
 * same function to repeat the process for the subsequent k groups.
 *
 * Time complexity - O(n)
 * Space complexity - O(n / k) - maximum depth of rescursion tree where n is number of nodes
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) {
            return head;
        }
        
        int count = 0;
        ListNode curr = head;

        // Count total nodes in list to divide it in k groups
        while(curr != null) {
            curr = curr.next;
            count++;
        }

        curr = head.next;
        ListNode prev = head;

        return reverse(head, curr, prev, count / k, k);
    }

    public ListNode reverse(ListNode head, ListNode curr, ListNode prev, int group, int k) {
        if(group == 0) {
            // No group left to reverse
            return head;
        }

        // Reverse current group
        int i = 1;
        while(i != k) {
            prev.next = curr.next;
            curr.next = head;
            head = curr;
            curr = prev.next;
            i++;
        }

        if(curr != null) {
            ListNode next = reverse(curr, curr.next, curr, group - 1, k);
            prev.next = next;
        }

        return head;
    }
}


// Link to problem - https://www.codingninjas.com/studio/problems/reverse-list-in-k-groups_983644
public class Solution {
    public static Node kReverse(Node head, int k) {
        // List with 0 or 1 node or group size is 1
        if(head == null || head.next == null || k == 1) {
            return head;
        }
        
        int count = 0;
        Node curr = head;

        // Count total nodes in list to divide it in k groups
        while(curr != null) {
            curr = curr.next;
            count++;
        }

        curr = head.next;
        Node prev = head;

        return reverse(head, curr, prev, count / k, k);
    }

    public static Node reverse(Node head, Node curr, Node prev, int group, int k) {
        if(group == 0) {
            // No group left to reverse
            return head;
        }

        // Reverse current group
        int i = 1;
        while(i != k) {
            prev.next = curr.next;
            curr.next = head;
            head = curr;
            curr = prev.next;
            i++;
        }

        if(curr != null) {
            Node next = reverse(curr, curr.next, curr, group - 1, k);
            prev.next = next;
        }

        return head;
    }
}
