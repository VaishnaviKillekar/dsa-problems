// Link to problem - https://leetcode.com/problems/copy-list-with-random-pointer/description/

/**
 * Intuition - Create interwoven copy nodes in the given list such that node in
 * the given list 'curr' next pointer points to its copy. The copy node's next
 * pointer points to curr.next.
 *
 * Now populate random pointers of copy nodes such that random pointer of given
 * list's current node 'curr' would correspond to next node of curr pointer.
 * (Trace this code on a whiteboard for better understanding).
 *
 * Then remove the interwoven connections to separate the lists.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
/*
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }

        // Create copy nodes interlaced in given list
        Node curr = head;
        while(curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Assign head of copy list
        Node copyHead = head.next;

        // Populate random pointers of copy nodes
        curr = head;
        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Separate copy nodes to create copy list from original list
        curr = head;
        Node copy = head.next;
        while(curr != null && curr.next != null && copy != null) {
            curr.next = copy.next;
            copy.next = curr.next != null ? curr.next.next : null;
            curr = curr.next;
            copy = copy.next;
        }

        return copyHead;
    }
}


/**
 * Intuition - Brute force approach
 * Create the deep copy list by populating only next pointers using given list
 * and counting the total number of nodes.
 * Now scan through the lists again and check if the random pointer for current
 * node is not null. If it's not null, then count the number of nodes after it
 * in the given list. Now subtract the total nodes with this position 'pos'.
 * Now iterate through the deep copy from its head until 'pos' to get the
 * corresponding random pointer in deep copy.
 *
 * Time complexity - O(n^2)
 * Space complexity - O(n)
 */
class Solution {
    public Node copyRandomList(Node head) {
        Node copyHead = null;
        Node curr = head;
        Node prev = null;
        int count = 0;

        // Create deepy copy with only next pointers & count total nodes in list
        while(curr != null) {
            Node node = new Node(curr.val);
            node.random = null;
            if(prev != null) {
                // Subsequent node - populate next of previous node
                prev.next = node;
            }
            else {
                // First node of copy - assign head
                copyHead = node;
            }
            prev = node;
            count++;
            curr = curr.next;
        }

        // Populate random pointers
        curr = head;
        Node copy = copyHead;
        while(curr != null) {
            Node random = curr.random;
            if(random != null) {
                int pos = count - getRandomPosition(random);
                populateRandomPointer(copyHead, copy, pos);
            }
            curr = curr.next;
            copy = copy.next;
        }

        return copyHead;
    }

    public int getRandomPosition(Node random) {
        Node curr = random;
        int pos = 0;
        while(curr != null) {
            pos++;
            curr = curr.next;
        }
        return pos;
    }

    public void populateRandomPointer(Node copyHead, Node copy, int pos) {
        Node curr = copyHead;
        for(int i = 0; i < pos; i++) {
            curr = curr.next;
        }
        copy.random = curr;
    }
}
