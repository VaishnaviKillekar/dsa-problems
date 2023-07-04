// Link to problem - https://www.codingninjas.com/studio/problems/sort-linked-list-of-0s-1s-2s_1071937

/**
 * Intuition - Scan list and sort 0s and 2s to the start and end of list.
 * Move all 0s to the front of list by updating head and move all 2s to
 * the end of list by updating tail. Use a pointer 'two' to track the start
 * of sorted 2s to avoid infinite looping.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
public class Solution
{
    public static Node sortList(Node head) {
        Node curr = head;
        Node prev = null;
        Node two = null;
        Node tail = null;

        // Iterate through the list to get the tail
        while (curr.next != null) {
            curr = curr.next;
        }

        tail = curr;    // Assign last node to tail
        two = tail;

        curr = head;
        while(curr != two) {
            if(curr.data == 0 && prev != null) {
                Node temp = curr;
                prev.next = temp.next;
                curr = prev.next;
                temp.next = head;
                head = temp;
            }
            else if(curr.data == 2) {
                tail.next = curr;
                tail = curr;
                if(prev != null) {
                    prev.next = curr.next;
                    curr.next = null;
                    curr = prev.next;
                }
                else {
                    curr = curr.next;
                    tail.next = null;
                    head = curr;
                }
            }
            else {
                prev = prev != null ? prev.next : curr;
                curr = curr.next;
            }
        }

        if(curr.data == 0) {
            // last unsorted node is 0
            prev.next = curr.next;
            curr.next = head;
            head = curr;
        }

        return head;
    }
}
