// Link to problem - https://leetcode.com/problems/symmetric-tree/

/**
 * Intuition - Brute force approach using recursion.
 * Traverse the left subtree using preorder -> root-left-right. Traverse the right subtree using custom order -> root-right-left.
 * Add all traversed nodes in two separate lists and compare them to determine if the binary tree is symmetrical.
 *
 * Time complexity - O(n)
 * Space complexity - O(n+logn) -> O(n)
 */
 class Solution {
    public boolean isSymmetric(TreeNode root) {
        List<Integer> leftSub = new ArrayList<>();
        List<Integer> rightSub = new ArrayList<>();
        
        preorder(root.left, leftSub);
        traverse(root.right, rightSub);
        
        if(leftSub.size() == rightSub.size() && leftSub.equals(rightSub)) {
            return true;
        }
        
        return false;
    }
    
    public void preorder(TreeNode root, List<Integer> leftSub) {
        if(root != null) {
            leftSub.add(root.val);
            preorder(root.left, leftSub);
            preorder(root.right, leftSub);
        }
        else {
            leftSub.add(null);
        }
    }
    
    public void traverse(TreeNode root, List<Integer> rightSub) {
        if(root != null) {
            rightSub.add(root.val);
            traverse(root.right, rightSub);
            traverse(root.left, rightSub);
        }
        else {
            rightSub.add(null);
        }
    }
}


/**
 * Intuition - Recursion approach without additional variables.
 * Traverse the left subtree and right subtree while comapring value of current node, followed by left.left and right.right child 
 * and then with left.right and right.left.
 *
 * Time complexity - O(n)
 * Space complexity - O(logn)
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isEqual(root.left, root.right);
    }
    
    public boolean isEqual(TreeNode left, TreeNode right) {
        if(left != null && right != null) {
            return left.val == right.val && isEqual(left.left, right.right) && isEqual(left.right, right.left);
        }
        else if(left == null && right == null) {
            return true;
        }
        return false;
    }
}
