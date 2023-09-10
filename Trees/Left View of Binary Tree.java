// Link to problem - https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1

/**
 * Intuition - Use a HashMap of HashMap to store every unique row and the leftmost
 * column corresponding to it. Only the node in the leftmost column is stored per row
 * as it will be the only visible node from the left.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Tree
{
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Map<Integer, Integer>> rowColMap = new HashMap<>();
        
        if(root == null) {
            return result;
        }
        
        // Get the first node for each row
        traverse(root, rowColMap, 0, 0);
        
        // Get the left view
        List<Integer> rows = new ArrayList<>(rowColMap.keySet());
        Collections.sort(rows);
        for(Integer row : rows) {
            // Add the only entry (leftmost column) for that row
            result.add(rowColMap.get(row).entrySet().iterator().next().getValue());
        }
        
        return result;
    }
    
    void traverse(Node node, Map<Integer, Map<Integer, Integer>> rowColMap, int row, int col) {
        if(node == null) {
            return;
        }
        
        // Is this row discovered?
        if(rowColMap.get(row) == null) {
            // Row found for the first time
            rowColMap.put(row, new HashMap<>());
        }
        
        // Is this the first column discovered for this row? If yes, it is leftmost
        if(rowColMap.get(row).size() == 0) {
            // No rows found - add current row node
            Map<Integer, Integer> colMap = new HashMap<>();
            colMap.put(col, node.data);
            rowColMap.put(row, colMap);
        }
        
        traverse(node.left, rowColMap, row + 1, col - 1);
        traverse(node.right, rowColMap, row + 1, col + 1);
    }
}
