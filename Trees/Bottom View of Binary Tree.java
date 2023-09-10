// Link to problem - https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

/**
 * Intuition - Use a HashMap of HashMap to store every unique column and the lowest
 * row corresponding to it. Only the node in the lowest is stored per column since
 * it will be the only visible node from the bottom. If there are multiple nodes in
 * the same row for the same column, store the last found node.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution
{
    public ArrayList <Integer> bottomView(Node root)
    {
        Map<Integer, Map<Integer, Integer>> colRowMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        // Traverse tree and collect all nodes in unique rows and columns
        traverse(root, colRowMap, 0, 0);
        
        // Get bottom view
        List<Integer> cols = new ArrayList<>(colRowMap.keySet());
        Collections.sort(cols);
        for(Integer col : cols) {
            // Only the last row node is stored per column
            result.add(colRowMap.get(col).entrySet().iterator().next().getValue());
        }
        
        return result;
    }
    
    public void traverse(Node node, Map<Integer, Map<Integer, Integer>> colRowMap, int row, int col) {
        if(node == null) {
            return;
        }
        
        // Is this column discovered?
        if(colRowMap.get(col) == null) {
            colRowMap.put(col, new HashMap<>());
        }
        
        // Is this row the lower than current?
        if(colRowMap.get(col).size() == 0) {
            // This is the first row for given column
            Map<Integer, Integer> rowMap = new HashMap<>();
            rowMap.put(row, node.data);
            colRowMap.put(col, rowMap);
        }
        else {
            // Check if existing row <= current row
            int existingRow = colRowMap.get(col).entrySet().iterator().next().getKey();
            if(existingRow <= row) {
                Map<Integer, Integer> rowMap = colRowMap.get(col);
                rowMap.remove(existingRow);
                rowMap.put(row, node.data);
                colRowMap.put(col, rowMap);
            }
        }
        
        traverse(node.left, colRowMap, row + 1, col - 1);
        traverse(node.right, colRowMap, row + 1, col + 1);
    }
}
