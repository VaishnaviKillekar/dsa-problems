// Link to problem - https://www.codingninjas.com/studio/problems/design-a-stack-that-supports-getmin-in-o-1-time-and-o-1-extra-space_842465

/**
 * Intuition - Using linked list
 * Design a doubly linked list which also stores the current minimum element seen so far.
 * While pushing an element, compare previous minimum with current value. If current is
 * lower previous minimum, then update the minimum in current node during insertion.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
public class Solution {
    static class Node {
        int val;
        Node prev;
        Node next;
        int min;

        Node() {}

        Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        Node(int val, Node prev, Node next, int min) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.min = min;
        }
    }

    static class SpecialStack {
        Node dummy = new Node(-1, null, null, Integer.MAX_VALUE);
        Node curr = dummy;

        void push(int data) {
            Node node = new Node(data, curr, null);
            node.min = curr.min < data ? curr.min : data;
            curr.next = node;
            curr = node;
        }

        void pop() {
            if(curr != dummy) {
                curr.prev.next = null;
                curr = curr.prev;
            }
        }

        int top() {
            return curr.val;
        }

        int getMin() {
            return curr.min;
        }
    };
}
