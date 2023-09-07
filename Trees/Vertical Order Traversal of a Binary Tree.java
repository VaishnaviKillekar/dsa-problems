// Link to problem - https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/ (HARD)

/**
 * Intuition - Brute Force approach
 * Traverse the tree and store every node in the map based on its row and column. The Map stores 
 * nodes such that the column represents the key and the value is another map with row as key and
 * value as nodes of that row and column. We need to store both row and column in order to sort
 * the elements in the same row for a given vertical column.
 *
 * Time complexity - O(n) - verify
 * Space complexity - O(n)
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> distMap = new HashMap<>(); // col x rows
        List<List<Integer>> result = new ArrayList<>();
        
        // Get horizontal and vertical distance of all nodes with root at (0,0)
        traverse(root, distMap, 0, 0);
        System.out.println("map - " + distMap);
        
        // Add nodes of distances in increasing order
        List<Integer> cols = new ArrayList<>(distMap.keySet());
        Collections.sort(cols);
        for(Integer col : cols) {
            Map<Integer, List<Integer>> rowMap = distMap.get(col);
            List<Integer> rows = new ArrayList<>(rowMap.keySet());
            Collections.sort(rows);
            List<Integer> verticalColumn = new ArrayList<>();
            for(Integer row : rows) {
                List<Integer> nodes = rowMap.get(row);
                Collections.sort(nodes);
                verticalColumn.addAll(nodes);
            }
            result.add(verticalColumn);
        }
        
        return result;
    }

    public void traverse(TreeNode node, Map<Integer, Map<Integer, List<Integer>>> distMap, int row, int col) {
        if(node == null) {
            return;
        }
        
        // Add current node to distance map
        Map<Integer, List<Integer>> colMap = distMap.get(col);
        if(colMap == null) {
            colMap = new HashMap<Integer, List<Integer>>();
            colMap.put(row, new ArrayList<Integer>());
        }

        List<Integer> rowNodes = colMap.get(row);
        if(rowNodes == null) {
            rowNodes = new ArrayList<Integer>();
        }
        rowNodes.add(node.val);
        colMap.put(row, rowNodes);
        distMap.put(col, colMap);
        
        traverse(node.left, distMap, row + 1, col - 1);
        traverse(node.right, distMap, row + 1, col + 1);
    }
}
