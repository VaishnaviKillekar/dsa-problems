// Link to problem - https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1

/**
 * Recursive approach with constant time
 * Here separate recursive calls to isBalanced and height function are removed and merged as one.
 * The return value consists of both the height as well as if subtree is balanced or not.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Tree
{
    boolean isBalanced(Node root)
    {
    	int[] result = helper(root);
    	return result[0] == 1;
    }
    
    int[] helper(Node root) {
        if(root == null) {
    	    return new int[] {1, 0};
    	}
    	
    	int[] lh = helper(root.left);
    	int[] rh = helper(root.right);
    	boolean balanced = lh[0] == 1 && rh[0] == 1 && Math.abs(lh[1] - rh[1]) <= 1;
    	
    	return new int[] {balanced ? 1 : 0, 1 + Math.max(lh[1], rh[1])};
    }
}


/**
 * Intuition - Regular recursive approach
 *
 * Time complexity - O(n^2)
 * Space complexity - O(n)
 */
class Tree
{
    boolean isBalanced(Node root)
    {
    	if(root == null) {
    	    return true;
    	}
    	
    	return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }
    
    int height(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}

