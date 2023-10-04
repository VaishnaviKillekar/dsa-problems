// Link to problem - https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1

/**
 * Intuition - Single pass solution
 * Traverse through the tree for finding n1 and n2 using recursion. When n1 or n2
 * is found, return the current node. If ancestors for both n1 and n2 are found,
 * then return the current node at that recursion level. Otherwise, return the
 * non-null ancestor.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution
{
	Node lca(Node root, int n1, int n2)
	{
		if(root == null) {
		    return null;
		}
		
		if(root.data == n1 || root.data == n2) {
		    return root;
		}
		
		Node leftAncestor = lca(root.left, n1, n2);
		Node rightAncestor = lca(root.right, n1, n2);
		
		if(leftAncestor != null && rightAncestor != null) {
		    return root;    
		}
		else if(leftAncestor != null && rightAncestor == null) {
		    return leftAncestor;
		}
		else if(leftAncestor == null && rightAncestor != null) {
		    return rightAncestor;
		}
		else {
		    return null;
		}
	}
}


/**
 * Intuition - Two pass solution
 * Traverse through the tree for finding n1 and n2 separately.
 * Record all ancestors while backtracking when the node is found. This will
 * give us two ancestor lists for n1 and n2. Now compare the ancestors in
 * both lists from the end, to get the lowest ancestor.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution
{
	Node lca(Node root, int n1, int n2)
	{
		List<Node> n1Ancestors = getAncestors(root, n1, new ArrayList<Node>());
		List<Node> n2Ancestors = getAncestors(root, n2, new ArrayList<Node>());
		Node lca = null;
		
		// n1 and n2 are not present
		if(n1Ancestors.size() == 0) {
		    return lca;
		}
		
		// Start comparing nodes backwards to get lowest ancestor
		int i = n1Ancestors.size() - 1;
		int j = n2Ancestors.size() - 1;
		
		while(i >= 0 && j >= 0) {
		    if(n1Ancestors.get(i).data == n2Ancestors.get(j).data)
		        lca = n1Ancestors.get(i);
		    i--;
		    j--;
		}
		
		return lca;
	}
	
	List<Node> getAncestors(Node node, int n, List<Node> path) {
	    if(node == null) {
	        return path;
	    }
	    
	    if(node.data == n) {
	        // Found node, backtrack and record all ancestors
	        path.add(node);
	        return path;
	    }
	    
	    path = getAncestors(node.left, n, path);
	    if(path.size() > 0) {
	        // Node was found - now we are backtracking for ancestors, add current node
	        path.add(node);
	        return path;
	    }

	    path = getAncestors(node.right, n, path);
	    if(path.size() > 0) {
	        // Node was found - now we are backtracking for ancestors, add current node
	        path.add(node);
	        return path;
	    }
	    
	    return path;
	}
}
