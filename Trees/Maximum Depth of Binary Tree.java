// Link to problem - https://leetcode.com/problems/maximum-depth-of-binary-tree/

/**
 * Concise solution
 *
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root != null) {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));    
        }
        else {
            return 0;
        }
    }
}


/*
 * Intuition - The height of tree can be computed by computing the height of left & right subtree.
 * Every non-null child adds one to the height to that side of the tree.
 *
 * Time complexity - O(n)
 * Space complexity - O(logn)
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return getHeight(root);
    }

    public int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
