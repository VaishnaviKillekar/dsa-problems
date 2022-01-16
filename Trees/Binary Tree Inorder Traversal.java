// Link to problem - https://leetcode.com/problems/binary-tree-inorder-traversal/

/**
 * Intuition - Start processing at root, then go left and followed by right.
 * Inorder - left-root-right
 *
 * Time complexity - O(n)
 * Space complexity - O(logn)
 */
lass Solution {
    
    List<Integer> inorder = new ArrayList<>();
        
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return inorder;
    }

    public void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left != null)
            traverse(root.left);
 
        inorder.add(root.val);

        if(root.right != null)
            traverse(root.right);
    }
}
