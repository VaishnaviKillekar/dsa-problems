// Link to problem - https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1

/**
 * Intuition - Use a HashMap to store every unique row and the leftmost
 * node in it i.e., the first found node as it will be the only visible 
 * node from the left.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Tree
{
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> rowMap = new HashMap<>();
        
        if(root == null) {
            return result;
        }
        
        // Get the first node for each row
        traverse(root, rowMap, 0);
        
        // Get the left view
        List<Integer> rows = new ArrayList<>(rowMap.keySet());
        Collections.sort(rows);
        for(Integer row : rows) {
            result.add(rowMap.get(row));
        }
        
        return result;
    }
    
    void traverse(Node node, Map<Integer, Integer> rowMap, int row) {
        if(node == null) {
            return;
        }
        
        // Is this row discovered?
        if(rowMap.get(row) == null) {
            // Row found for the first time
            rowMap.put(row, node.data);
        }
        
        traverse(node.left, rowMap, row + 1);
        traverse(node.right, rowMap, row + 1);
    }
}
