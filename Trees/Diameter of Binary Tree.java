// Link to problem - https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1

/**
 * Intuition - Maximum diameter of a tree can be found:
 * 1. Left subtree
 * 2. Right subtree
 * 3. Combination of both subtree (entire tree)
 *
 * Hence, we compute all 3 possibilities. The diameter is obtained by adding up all nodes between the farthermost leaves in
 * each subtree - to do so, we need to compute height of subtrees and add them along with root.
 * This is why we compute height in every call of diameter.
 *
 * Time complexity - O(n^2) - for every recursive call to diameter (takes O(n)), height is also called which also takes O(n)
 * Space complexity -O(n)
 */
class Solution {
    int diameter(Node root) {
        if(root == null) {
            return 0;
        }
        
        int ld = diameter(root.left);
        int rd = diameter(root.right);
        int fullTreeHeight = 1 + height(root.left) + height(root.right);
        
        return Math.max(Math.max(ld, rd), fullTreeHeight);
    }
    
    int height(Node node) 
    {
        if(node == null) {
            return 0;
        }
        
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
