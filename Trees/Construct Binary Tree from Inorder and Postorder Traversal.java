// Link to problem - https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

/**
 * Intuition - In postorder traversal, the root is at the end, so the postorder[] is
 * scanned right to left. Create a new node using current postorder index and the left
 * and right children and subtree is constructed using recursion. The postorder start
 * and end index are tracked along with inorder start and end indexes. When the start
 * index surpasses the end, then backtrack.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }        

        return buildTree(inorder, postorder, inorderMap, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, Map<Integer, Integer> inorderMap, int postStart, int postEnd, int inStart, int inEnd) {
        if(postStart > postEnd || inStart > inEnd) {
            return null;
        }

        // Create current node
        TreeNode curr = new TreeNode(postorder[postEnd]);

        // Get position of current node in inorder
        int position = inorderMap.get(postorder[postEnd]);

        // Get children of current node
        curr.left =  buildTree(inorder, postorder, inorderMap, postStart, postStart + position - inStart - 1, inStart, position - 1);
        curr.right = buildTree(inorder, postorder, inorderMap, postStart + position - inStart, postEnd - 1, position + 1, inEnd);

        return curr;
    }
}
