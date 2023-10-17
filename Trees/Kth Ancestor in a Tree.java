// Link to problem - https://practice.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1

/**
 * Intuition - Traverse the tree nodes until given node is found. Once found, mark the current
 * node level as 0 and increment level during backtracking. When the level becomes equal to k,
 * store the node at level as ancestor.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution
{
    public int kthAncestor(Node root, int k, int node)
    {
        int[] result = findNode(root, k, node, -1);
        return result[0] >= k ? result[1] : -1;
    }
    
    public int[] findNode(Node root, int k, int node, int level)
    {
        if(root == null) {
            return new int[] {level, -1}; 
        }
        
        if(root.data == node) {
            // Found node - backtrack to reach level k. 
            // Current level is set to 0. Ancestor is set to -1.
            return new int[] {0, -1};
        }
        
        int[] left = findNode(root.left, k, node, level);
        if(left[0] != -1) {
            left[0]++;
            return new int[] {left[0], left[0] <= k ? root.data : left[1]};
        }
        
        int[] right = findNode(root.right, k, node, level);
        if(right[0] != -1) {
            right[0]++;
            return new int[] {right[0], right[0] <= k ? root.data : right[1]};
        }
        
        return new int[] {level, -1}; 
    }
}
