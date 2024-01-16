// Link to problem - https://leetcode.com/problems/convert-bst-to-greater-tree/description/
// Same question - https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/

/**
 * Intuition - Optimised approach to reduce space taken by array.
 * Get reverse inorder traversal (Right-Left-Root) of the tree and update the value
 * of each node by adding the sum computed so far.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if(root == null) {
            return root;
        }
        
        bstToGst(root.right);
        root.val += sum;
        sum = root.val;
        bstToGst(root.left);

        return root;
    }
}



/**
 * Intuition - Get the inorder traversal of the tree and store it as an array of nodes.
 * Iterate through this array in reverse and add the sum of all elements scanned so far.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> inorder = new ArrayList<>();

        // Get inorder traversal of tree
        getInorder(root, inorder);

        // Convert BST to greater tree - get greater key for each node in tree
        int sum = 0;
        for(int i = inorder.size() - 1; i >= 0; i--) {
            TreeNode curr = inorder.get(i);
            curr.val += sum;
            sum = curr.val;
        }

        return root;
    }

    public void getInorder(TreeNode root, List<TreeNode> inorder) {
        if(root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root);
        getInorder(root.right, inorder);
    }
}
