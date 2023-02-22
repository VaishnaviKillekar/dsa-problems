// Link to problem - https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

/**
 * Intuition - DFS with O(1) space
 * Use two pointers - 'prev' to store the current node and 'curr' to move across nodes from
 * left to right using 'next'.
 * Using 'curr', first populate the 'next' pointer in siblings of 'curr'. Then check if 'curr'
 * has a sibling using its 'next' pointer. If yes, then populate the 'next' pointer of 'curr's
 * right child with curr's sibling's left child (cousins). Then move to 'curr's sibling and repeat.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
};
*/

class Solution {
    public Node connect(Node root) {
        Node prev = root;
        Node curr = null;

        if(root == null) {
            return root;
        }

        while(prev.left != null) {
            curr = prev;
            while(curr != null) {
                // Populate next pointer in children
                curr.left.next = curr.right;
                
                // Populate next pointer in cousins (parent nodes are siblings)
                if(curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                // Move to the sibling of current node (move right)
                curr = curr.next;
            }
            prev = prev.left;
        }

        return root;
    }
}

/**
 * Intuition - Level order with O(n) space
 * Get the level order traversal for given binary tree. Iterate through the levels
 * and populate the next pointers.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Node>> levelOrder = new ArrayList<>();

        if(root == null) {
            return root;
        }
        queue.add(root);

        while(queue.size() > 0) {
            int count = queue.size();
            List<Node> level = new ArrayList<>();

            for(int i = 0; i < count; i++) {
                Node curr = queue.poll();
                level.add(curr);
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
            levelOrder.add(level);
        }

        // Populate next pointer
        for(List<Node> level : levelOrder) {
            for(int i = 0; i < level.size() - 1; i++) {
                Node curr = level.get(i);
                curr.next = level.get(i + 1);
            }
        }

        return root;
    }
}
