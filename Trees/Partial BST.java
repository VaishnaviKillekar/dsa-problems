// Link to problem - https://www.codingninjas.com/studio/problems/validate-bst_799483?leftPanelTab=0

/**
 * Intuition - Each node in the tree has to follow min and max constraints.
 * The left node can have any minimum value but it cannot exceed max of root.
 * Similarly, right node can have any maximum value but it can't be lower
 * than root.
 *
 * Alternate approach - Inorder traversal must be in non-decreasing order.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
public class Solution {
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        return isPartialBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isPartialBst(BinaryTreeNode<Integer> root, int min, int max) {
        if(root == null) {
            return true;
        }

        boolean isValid = false;
        if(root.data >= min && root.data <= max) {
            isValid = true;
        }

        return isValid && isPartialBst(root.left, min, root.data) 
            && isPartialBst(root.right, root.data, max);
    }
}
