// Link to problem - https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1

/**
 * Intuition - Use a HashMap of HashMap to store the column and row of nodes.
 * In every row, only the first node is stored as this alone is visible from the top.
 * Store all rows per column as rows could be discovered in a random order.
 * Iterate through the HashMaps and sort the rows and columns and pick only the firsts.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution
{
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Map<Integer, Integer>> colRowNodeMap = new HashMap<>();
        
        // Find row and column for each node and store the first element in each row
        traverse(root, colRowNodeMap, 0 , 0);

        // Get the top view
        List<Integer> cols = new ArrayList<>(colRowNodeMap.keySet());
        Collections.sort(cols);
        for(Integer col : cols) {
            List<Integer> rows = new ArrayList<>(colRowNodeMap.get(col).keySet());
            Collections.sort(rows);
            // Get the first row as the element in this is visible from top
            result.add(colRowNodeMap.get(col).get(rows.get(0)));
        }
        
        return result;
    }
    
    static void traverse(Node node, Map<Integer, Map<Integer, Integer>> colRowNodeMap, int row, int col) {
        if(node == null) {
            return;
        }
        
        // If this column has been not found - create an entry
        if(colRowNodeMap.get(col) == null) {
            colRowNodeMap.put(col, new HashMap<Integer, Integer>());
        }
        
        // If this row has been not found - add current node to row x col
        if(colRowNodeMap.get(col).get(row) == null) {
            Map<Integer, Integer> rowMap = colRowNodeMap.get(col);
            rowMap.put(row, node.data);
            colRowNodeMap.put(col, rowMap);
        }
        
        traverse(node.left, colRowNodeMap, row + 1, col - 1);
        traverse(node.right, colRowNodeMap, row + 1, col + 1);
    }
}
