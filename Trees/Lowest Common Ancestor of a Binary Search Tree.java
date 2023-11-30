// Link to problem - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

/**
 * Intuition - Iterative approach
 * If p and q are both greater than root, then they lie in the right subtree of root
 * If p and q are both lesser than root, then they lie in the left subtree of root
 * Else they lie on either subtree of root
 *
 * This logic can be applied iteratively to find p and q.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp = root;

        while (root != null) {
            if(root.val > p.val && root.val > q.val) {
                // Both nodes lie in the left subtree of root
                root = root.left;
            }
            else if(root.val < p.val && root.val < q.val) {
                // Both nodes lie in the right subtree of root
                root = root.right;
            }
            else {
                // Both nodes lie on either subtrees of root or root = p or root = q
                return root;
            }
        }

        return temp;
    }
}


/**
 * Intuition - Recursive approach
 * If p and q are both greater than root, then they lie in the right subtree of root
 * If p and q are both lesser than root, then they lie in the left subtree of root
 * Else they lie on either subtree of root
 *
 * This logic can be applied as recursion to find p and q.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val) {
            // Both nodes lie in the left subtree of root
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(root.val < p.val && root.val < q.val) {
            // Both nodes lie in the right subtree of root
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            // Both nodes lie on either subtrees of root or root = p or root = q
            return root;
        }
    }
}
