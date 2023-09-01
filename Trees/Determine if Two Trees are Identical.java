// Link to problem - https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1

/**
 * Intuition - Compare each and every node of the two lists.
 * If current nodes are equal, then compare their children recursively.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution
{
	boolean isIdentical(Node root1, Node root2)
	{
	    if(root1 == null && root2 == null) {
	        return true;
	    }
	    else if((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
	        return false;
	    }
	    
	    if(root1.data == root2.data) {
	        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
	    }
	    else {
	        return false;
	    }
	}
}
