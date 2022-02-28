// Link to problem - https://leetcode.com/problems/same-tree/

/*
 * Intuition - Traverse both trees using recursion and compare the current node
 *
 * Time complexity - O(n)
 * Space complexity - O(logn)
 */
 
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return traverse(p, q);
    }
    
    public boolean traverse(TreeNode p, TreeNode q) {
        if(p != null && q != null) {
            if(p.val == q.val) {
                return traverse(p.left, q.left) && traverse(p.right, q.right);
            }
            else {
                return false;
            }
        }

        else if(p == null && q == null) {
            return true;
        }

        return false;
    }
}
