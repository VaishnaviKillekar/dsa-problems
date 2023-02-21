// Link to problem - https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

/**
 * Intuition - Recursion
 * Start with first element in preorder as root. The left subtree and the right subtree of root
 * are the elements to the left and right of the root node in inorder respectively.
 * Recurse to find the left and right child nodes.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();

        buildIndexMap(inorderMap, inorder);

        return buildTree(preorder, inorder, inorderMap, 0, 0, preorder.length - 1);        
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap, int pre, int inStart, int inEnd) {
        if(pre > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        int currIndex = inorderMap.get(preorder[pre]);
        TreeNode curr = new TreeNode(preorder[pre]);

        curr.left = buildTree(preorder, inorder, inorderMap, pre + 1, inStart, currIndex - 1);
        // Right child of current node in preorder is after all the left nodes of current node. So we get a count
        // of all nodes in inorder on the left and then increment by 1 -> (currIndex - inStart) + 1
        curr.right = buildTree(preorder, inorder, inorderMap, pre + currIndex - inStart + 1, currIndex + 1, inEnd);
        return curr;
    }

    public void buildIndexMap(Map<Integer, Integer> inorderMap, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
    }
}
