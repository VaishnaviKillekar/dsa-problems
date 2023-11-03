// Link to problem - https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

/**
 * Intuition - Inorder traversal of BST gives nodes in ascending order. Hence, use Inorder
 * traversal to track the kth smallest node. On finding the first node, increment counter
 * until it reaches k and return the node.
 * 
 * Time complexity - O(n)
 * Space complexity - O(n)
 *
 * Follow up: Refer https://stackoverflow.com/questions/77094973/how-to-find-kth-smallest-element-in-a-bst-when-the-tree-may-be-modified-frequent
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] result = inorder(root, k, new int[] {0, -1});
        return result[1];
    }

    public int[] inorder(TreeNode root, int k, int[] prev) {
        if(prev[0] == k || root == null) {
            return prev;
        }

        // Left
        int[] left = inorder(root.left, k, prev);

        // Node: Found smallest - this is executed only after 1st node in inorder
        left[0]++;
        if(left[0] == k) {
            left[1] = root.val;
            return left;
        }

        // Right
        return inorder(root.right, k, prev);
    }
}
