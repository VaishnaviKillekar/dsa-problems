// Link to problem - https://leetcode.com/problems/minimum-depth-of-binary-tree/

/*
 * Intuition - Recursive approach
 * The minimum height can be computed by comparing the left and right subtree of each node and the one with the
 * lower height is taken as the height of that node.
 * We ensure to recurse only when there is a node i.e., if a node does not have a left child, then do not call
 * the function with node.left. Do a check first. Otherwise, the non-existent left child will return its height
 * as zero and this will wrongly set height to 0.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left != null && root.right != null) {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
        else if(root.left == null) {
            return 1 + minDepth(root.right);
        }
        else {
            return 1 + minDepth(root.left);
        }
    }
}
