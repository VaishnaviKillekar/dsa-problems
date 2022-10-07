// Link to problem - https://leetcode.com/problems/validate-binary-search-tree/

/**
 * Intuition - Recursively compare each node with its children. To also ensure
 * the BST property where every subtree is also a BST - all child nodes in
 * left subtree are smaller than parent and all child nodes in right subtree
 * are greater than parent for each node of the tree, we use 'min' and 'max'
 * nodes at every level.
 *
 * Time complexity - O(n)
 * Space complexity - O(nlogn)
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    public boolean isValid(TreeNode node, TreeNode min, TreeNode max) {
        if(node != null) {
            boolean valid = true;
            if(min != null && node.val <= min.val) {
                valid = false;
            }
            if(max != null && node.val >= max.val) {
                valid = false;
            }
            return valid && isValid(node.left, min, node) && isValid(node.right, node, max);
        }
        return true;
    }
}


/**
 * Intuition - Inorder traversal of a BST arranges its nodes in ascending order.
 * Run an inorder traversal and store the nodes in a list.
 * Once all nodes are traversed, check if the values are strictly increasing. 
 *
 * Time complexity - O(n)
 * Space complexity - O(nlogn)
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        inorder(list, root);

        for(int i = 1; i < list.size(); i++) {
            if(list.get(i) <= list.get(i-1)) {
                return false;
            }
        }
        
        return true;
    }
    
    public void inorder(List<Integer> list, TreeNode node) {
        if(node != null) {
            inorder(list, node.left);
            list.add(node.val);
            inorder(list, node.right);
        }
    }
}
