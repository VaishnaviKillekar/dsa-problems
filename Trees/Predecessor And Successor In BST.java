// Link to problem - https://www.codingninjas.com/studio/problems/_893049?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0&leftPanelTabValue=PROBLEM

/**
 * Intuition - Traverse the tree to kind the key and keep updating the pre & suc as
 * they could be possible predecessor and successor. When current node > key, then
 * current node could be a possible successor. Similarly, if current node < key, then
 * current node could be a possible predecessor.
 *
 * Once the search for key terminates, we check if it was found. If not, then return
 * pre & suc. If found, we further search the left and right subtree of key node.
 * 
 * Predecessor - maximum node in left subtree of key node.
 * Successor - minimum node in right subtree of key node.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
public class Solution {
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        TreeNode keyNode = root;
        int pre = -1;
        int suc = -1;

        // Find the key node
        while(keyNode != null && keyNode.data != key) {
            if(keyNode.data > key) {
                suc = keyNode.data;     // Possible successor
                keyNode = keyNode.left;
            }
            else {
                pre = keyNode.data;     // Possible predecessor 
                keyNode = keyNode.right;
            }
        }

        // If key does not exist, then current pre & suc hold the answer
        if(keyNode == null) {
            return Arrays.asList(pre, suc);
        }

        // Predecessor - max node in left subtree of key node
        TreeNode leftTree = keyNode.left;
        while(leftTree != null) {
            pre = leftTree.data;
            leftTree = leftTree.right;
        }

        // Successor - min node in right subtree of key node
        TreeNode rightTree = keyNode.right;
        while(rightTree != null) {
            suc = rightTree.data;
            rightTree = rightTree.left;
        }

        return Arrays.asList(pre, suc);
    }
}
