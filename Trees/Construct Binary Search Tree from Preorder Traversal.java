// Link to problem - 

/**
 * Intuition - Use max and min constraints on each node to determine if a 
 * node can be inserted as a child.
 *
 * Time complexity - O(n) - O(3n): at max all nodes will be visited thrice
 * Space complexity - O(n)
 */
class Solution {
    int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBst(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode buildBst(int[] preorder, int min, int max) {
        if(i >= preorder.length) {
            return null;
        }
        if(preorder[i] < min || preorder[i] > max) {
            return null;
        }

        TreeNode curr = new TreeNode(preorder[i++]);
        curr.left = buildBst(preorder, min, curr.val);
        curr.right = buildBst(preorder, curr.val, max);

        return curr;
    }
}
