// Link to problem - https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

/**
 * Intuition - Traverse the tree in 3 steps - 
 * First add root to the result.
 *
 * 1. Traverse the left subtree and store all leftmost nodes except for leaf node. 
 *      There might be a node which does not have left child so traverse to the right child as its leftmost nodes are to be included
 *
 * 2. Traverse leaf nodes using Inorder Traversal
 *
 * 3. Traverse the right subtree and store all rightmost nodes except for leaf node. 
 *      There might be a node which does not have a right child so traverse to the left child as its rightmost nodes are to be included.
 *
 * Time complexity - O(n)
 * Space complexity - O(height)
 */
class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList <Integer> result = new ArrayList();
	    Node head = node;
	    
	    // Add root to result
	    if(node != null) {
	        result.add(node.data);
	    }
	    
        // Print leftmost nodes except leaf node
        getLeftNodes(node.left, result);
        
        // Print all leaves from left to right
        node = head;
        getLeaves(node.left, result);
        getLeaves(node.right, result);
        
        // Print rightmost nodes except leaf node
        node = head.right;
        getRightNodes(node, result);
        
        return result;
	}
	
	void getLeftNodes(Node node, ArrayList<Integer> result) {
	    if(node == null || (node.left == null && node.right == null)) {
	        return;
	    }
	    result.add(node.data);
	    
	    if(node.left != null) {
	        // Go left if left child exists. Otherwise, go right to get those left nodes
	        getLeftNodes(node.left, result);
	    }
	    else {
	        getLeftNodes(node.right, result);   
	    }
	}
	
	void getLeaves(Node node, ArrayList<Integer> result) {
	    if(node == null) {
	        return;
	    }
	    if(node.left == null && node.right == null) {
	        result.add(node.data);
	    }
	    getLeaves(node.left, result);
	    getLeaves(node.right, result);
	}
	
	void getRightNodes(Node node, ArrayList<Integer> result) {
	    if(node == null || (node.left == null && node.right == null)) {
	        return;
	    }
	    
	    if(node.right != null) {
	        // Go right if right child exists. Otherwise, go left to get those right nodes
	        getRightNodes(node.right, result);
	    }
	    else {
	        getRightNodes(node.left, result);
	    }
	    result.add(node.data);
	}
}
