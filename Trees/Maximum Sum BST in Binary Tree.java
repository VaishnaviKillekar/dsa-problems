// Link to problem - https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/description/

/**
 * Intuition - Traverse all nodes in the tree and compute the sum of all subtrees and
 * check if they are a BST. Only in case the subtree is BST, update the maxSum if current
 * sum is greater. We use a special object to store all required details for each node.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    int maxSum = 0;

    class TreeNodeInfo {
        int min;
        int max;
        boolean isBst;
        int sum;

        TreeNodeInfo() {}

        TreeNodeInfo(int min, int max, boolean isBst, int sum) {
            this.min = min;
            this.max = max;
            this.isBst = isBst;
            this.sum = sum;
        }
    }

    public int maxSumBST(TreeNode root) {
        getMaxSumBst(root);
        return maxSum;
    }

    public TreeNodeInfo getMaxSumBst(TreeNode root) {
        if(root == null) {
            return new TreeNodeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);
        }

        TreeNodeInfo left = getMaxSumBst(root.left);
        TreeNodeInfo right = getMaxSumBst(root.right);

        int min = Math.min(root.val, left.min);
        int max = Math.max(root.val, right.max);
        boolean isBst = left.isBst && right.isBst && root.val > left.max && root.val < right.min;
        int sum = root.val + left.sum + right.sum;
        
        if(isBst) {
            maxSum = Math.max(maxSum, sum);
        }

        return new TreeNodeInfo(min, max, isBst, sum);
    }
}
