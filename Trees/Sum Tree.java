// Link to problem - https://practice.geeksforgeeks.org/problems/sum-tree/1

/**
 * Intuition - Traverse through child nodes of every node. If it's a leaf node,
 * then subtree is a sum tree and sum is value of node. Recurse through the
 * left and right subtree and add the sum of child subtree and compare with value
 * of node. While returning sum, always add up the sum of child subtrees and the
 * value of parent node.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution
{
	boolean isSumTree(Node root)
	{
        int[] result = helper(root);
        return result[0] == 1;
	}
	
	int[] helper(Node root) {
	    // Nodes with single child - sumTree = true and sum = 0
	    if(root == null) {
	        return new int[] {1, 0};
	    }
	    
	    if(root.left == null && root.right == null) {
            return new int[] {1, root.data};
        }
        
        int[] lsum = helper(root.left);
        int[] rsum = helper(root.right);
        int sum = lsum[1] + rsum[1];
        boolean sumTree = lsum[0] == 1 && rsum[0] == 1 && root.data == sum;
        
        return new int[] {sumTree ? 1 : 0, root.data + sum};
	}
}
