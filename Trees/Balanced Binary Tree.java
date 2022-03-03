// Link to problem - https://leetcode.com/problems/balanced-binary-tree/

/*
 * Intuition - Recursive approach
 * Start with the root and recursively compute the height of both its left and right subtree.
 * If the height difference its subtree is greater than 1, then return false as tree is not balanced.
 *
 * Time complexity - O(n^2) - verify since height is computed repeatedly for every node. For a skewed tree it becomes n^2
 * Space complexity - O(n) - skewed tree can end up having all nodes stacked during recursion
 *
 * TODO - Optimize finding height of node such that it need not be recomputed every time for a node. 
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return heightBalanced(root);
    }
    
    public boolean heightBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return heightBalanced(root.left) && heightBalanced(root.right) && 
            (Math.abs(getHeight(root.left) - getHeight(root.right)) < 2);
    }
    
    public int getHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
