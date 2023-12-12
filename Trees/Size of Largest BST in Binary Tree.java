// Link to problem - https://www.codingninjas.com/studio/problems/largest-bst-subtree_893103?leftPanelTab=0

/**
 * Intuition - Traverse the tree and check if every node is a BST and record 
 * the size of that subtree. This is a bottom-up recursion where size computation
 * starts from the leaf node and moves up towards root. We track the minimum and
 * maximum nodes in each subtree along with its size and whether it is a BST.
 * maxSize is used to store the final result.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
public class Solution {

    static class NodeInfo {
        int min;
        int max;
        int size;
        boolean isBst;
        int maxSize = 0;

        NodeInfo() {}

        NodeInfo(int min, int max, int size, boolean isBst, int maxSize) {
            this.min = min;
            this.max = max;
            this.size = size;
            this.isBst = isBst;
            this.maxSize = maxSize;
        }
    }

    public static int largestBST(TreeNode root) {
        NodeInfo result = getLargestBST(root);
        return result.maxSize;
    }

    public static NodeInfo getLargestBST(TreeNode root) {
        if(root == null) {
            NodeInfo nodeInfo = new NodeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true, 0);
            return nodeInfo;
        }

        NodeInfo left = getLargestBST(root.left);
        NodeInfo right = getLargestBST(root.right);

        int min = Math.min(root.data, left.min);
        int max = Math.max(root.data, right.max);
        int size = left.size + right.size + 1;
        boolean isBst = left.isBst && right.isBst && root.data > left.max && root.data < right.min;
        int maxSize = Math.max(left.maxSize, right.maxSize);

        if(isBst) {
            maxSize = Math.max(maxSize, size);
        }

        return new NodeInfo(min, max, size, isBst, maxSize);
    }
}
