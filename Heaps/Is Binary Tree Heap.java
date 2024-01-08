// Link to problem - https://www.geeksforgeeks.org/problems/is-binary-tree-heap/1

/**
 * Intuition - A binary tree is a heap if it is a complete tree and satisfies
 * the heap property. To check if it is complete, we need to ensure that there
 * are no null nodes in between. Get a count of nodes in the tree and check for
 * every node if its index exceeds count. If it is a complete binary tree, then
 * check for heap property.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    int count = 0;
    
    boolean isHeap(Node tree) {
        // Count number of nodes in BT
        count = getCount(tree);

        if(isCompleteBT(tree, 1) && isMaxHeap(tree)) {
            return true;
        }
        
        return false;
    }
    
    int getCount(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + getCount(root.left) + getCount(root.right);
    }
    
    boolean isCompleteBT(Node root, int index) {
        if(root == null) {
            return true;
        }
        
        if(index > count) {
            // If tree has null nodes in the middle, then this condiiton fails
            return false;
        }
        
        return isCompleteBT(root.left, 2 * index) && isCompleteBT(root.right, 2 * index + 1);
    }
    
    boolean isMaxHeap(Node root) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        
        // Node will always have left child since it's complete BT
        if(root.right == null) {
            // Node only has left child
            return root.data > root.left.data;
        }
        
        // Node has both children
        return root.data > root.left.data && root.data > root.right.data
            && isMaxHeap(root.left) && isMaxHeap(root.right);
    }
}
