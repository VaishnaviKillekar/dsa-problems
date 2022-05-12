// Link to problem - https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/

/**
 * Intuition - Recurse from root to leaf while passing the sum from previous level (parent) to next level (children).
 * If a leaf is encountered, check if the previous sum and current leaf node value are equal to the target.
 * If not, return false. Else, return true.
 * If a non-leaf is found, go through both its left and child child.
 *
 * Time complexity - O(n)
 * Space complexity - O(logn)
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        
        return getSum(root, targetSum, 0);
    }
    
    public boolean getSum(TreeNode node, int targetSum, int prevSum) {
        if(node.left == null && node.right == null) {
            if(prevSum + node.val == targetSum) {
                return true;
            }
            return false;
        }
        
        boolean leftTree = false, rightTree = false;
        if(node.left != null) {
            leftTree = getSum(node.left, targetSum, prevSum + node.val);
        }
        if(node.right != null) {
            rightTree = getSum(node.right, targetSum, prevSum + node.val);
        }
        return leftTree || rightTree;
    }
}
