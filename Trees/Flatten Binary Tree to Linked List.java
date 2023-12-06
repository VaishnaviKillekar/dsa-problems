// Link to problem - https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

/**
 * Intuition - Iterative approach
 * We iterate through the left subtree of each node and add to the right subtree
 * To do this, we traverse throught the left subtree of each node such that we
 * find the right-most node (no right child). This right-most node forms the
 * parent of curr.right and right-most node becomes the right child of curr
 * while left subtree of curr is made null. We continue this process until curr
 * becomes null.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while(curr != null) {
            if(curr.left != null) {
                TreeNode rightmost = curr.left;
                while(rightmost.right != null) {
                    // Get the rightmost node in left subtree
                    rightmost = rightmost.right;
                }
                // rightmost will become the right child of curr & right subtree of curr will become
                // right subtree of rightmost - tree is flattened
                rightmost.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }

            curr = curr.right;
        }
    }
}



/**
 * Intuition - Recursive approach
 * Use recursion to flattent subtree at each node into a right-skewed tree.
 * We first flatten the right subtree and then the left subtree so that
 * attaching left subtree before right is straightforward.
 * We also need to track the first and last nodes of the flattened subtree
 * to attach it correctly. In case of leaf nodes, they are both the start
 * and end.
 *
 * Time complexity - O(n)
 * Space complexity - O(n) - recursion tree depth
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }

        flattenTree(root);
    }

    public TreeNode[] flattenTree(TreeNode node) {
        // Leaf node - this is both start and end of subtree
        if(node.left == null && node.right == null) {
            return new TreeNode[] {node, node};
        }

        else if(node.right == null) {
            // Move left subtree to right
            node.right = node.left;
            node.left = null;
        }
        
        // Hold the start and end of the right & left subtree of current node
        TreeNode[] right = new TreeNode[] {null, null};
        TreeNode[] left = new TreeNode[] {null, null};

        if(node.right != null) {
            right = flattenTree(node.right);
        }
        if(node.left != null) {
            left = flattenTree(node.left);
        }

        // Flatten left & right subtrees into one
        if(left[0] != null) {
            // Left subtree exists, then add it before right
            node.right = left[0];
            left[1].right = right[0];
            node.left = null;
        }

        return new TreeNode[] {node, right[0] != null ? right[1] : left[1]};
    }
}
