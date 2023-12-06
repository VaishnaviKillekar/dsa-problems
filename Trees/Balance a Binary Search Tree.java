// Link to problem - https://leetcode.com/problems/balance-a-binary-search-tree/description/

/**
 * Intuition - To create a balanced BST, we first get the inorder traversal
 * which returns a sorted array. We then use this sorted array to construct
 * BST using binary search principle to pick the nodes.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> inorder = new ArrayList<>();
        traverse(root, inorder);

        // Use inorder to construct height-balanced BST
        int start = 0;
        int end = inorder.size() - 1;
        return buildBST(inorder, start, end);
    }

    public TreeNode buildBST(List<TreeNode> inorder, int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode curr = inorder.get(mid);

        // Get left and right child
        curr.left = buildBST(inorder, start, mid - 1);
        curr.right = buildBST(inorder, mid + 1, end);

        return curr;
    }

    public void traverse(TreeNode root, List<TreeNode> inorder) {
        if(root == null) {
            return;
        }
        traverse(root.left, inorder);
        inorder.add(root);
        traverse(root.right, inorder);
    }
}
