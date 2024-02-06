// Link to problem - https://leetcode.com/problems/trim-a-binary-search-tree/description/

/**
 * Intuition - Traverse the tree until leaf node is reached. Check if leaf node lies in the range.
 * If it does, then return it while backtracking. If not, then return null.
 * If an internal node is found, then continue to recurse both its subtress until leaf node.
 * While backtracking from internal nodes, verify it lies in the range. If yes, then return it as
 * it is. Otherwise, return its non-null subtree.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) {
            return null;
        }
        else if(root.left == null && root.right == null) {
            // This is a leaf node
            if(root.val >= low && root.val <= high) {
                return root;
            }
            else {
                return null;
            }
        }

        // This is not a leaf node
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        // Check if non-leaf node is out of range
        if(root.val < low || root.val > high) {
            return root.left != null ? root.left : root.right;
        }
        return root;
    }
}
