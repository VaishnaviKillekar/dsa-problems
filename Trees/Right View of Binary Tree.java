// Link to problem - https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1

/**
 * Intuition - Use recursion to traverse the tree (right child first) and 
 * every time a new row is visited, add the first node in result since the
 * first found node alone will be visible from the right view.
 * At every level/row, we add the node only when it is entered first time i.e.,
 * when the number of nodes in result matches the row level. Every other node
 * in that row is ignored.
 *
 * Time complexity - O(n)
 * Space complexity - O(n) - recursion
 */
class Solution {
    ArrayList<Integer> rightView(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        
        traverse(node, result, 0);
        
        return result;
    }
    
    void traverse(Node node, ArrayList<Integer> result, int row) {
        if(node == null) {
            return;
        }
        
        if(result.size() == row) {
            // Row discovered first time - add node
            result.add(node.data);
        }
        
        // Traverse right to left to get rightmost node first 
        traverse(node.right, result, row + 1);
        traverse(node.left, result, row + 1);
    }
}
