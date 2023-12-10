// Link to problem - https://leetcode.com/problems/merge-two-binary-trees/description/

/**
 * Intuition - Traverse both trees at once and merge every node along
 * the way.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return null;
        }
        
        TreeNode curr = new TreeNode();
        curr.val = (root1 != null ? root1.val : 0) + (root2 != null ? root2.val : 0);
        curr.left = mergeTrees(root1 != null ? root1.left : root1, root2 != null ? root2.left : root2);
        curr.right = mergeTrees(root1 != null ? root1.right : root1, root2 != null ? root2.right : root2);

        return curr;
    }
}
