// Link to problem - https://www.codingninjas.com/studio/problems/interview-shuriken-42-detect-and-remove-loop_241049

/**
 * Intuition - Flyod's Cycle Detection algorithm
 * Use the fast and slow pointer to detect cycles. If there is a cycle,
 * set the slow pointer to head while leaving fast pointer at the intersection.
 * Now advance both slow and fast poiinter by one position until they meet again
 * which indicates the node where cycle starts.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
public class Solution {
  public static Node removeLoop(Node head) {
    Node slow = head;
    Node fast = head.next;

    while(fast != null && fast.next != null && fast != slow) {
      fast = fast.next.next;
      slow = slow.next;
    }

    // List has no loop as there is a node with null as next pointer
    if(fast == null || fast.next == null) {
      return head;
    }

    // List has a loop since fast met slow
    slow = head;
    while(fast.next != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    fast.next = null;

    return head;
  }
}
