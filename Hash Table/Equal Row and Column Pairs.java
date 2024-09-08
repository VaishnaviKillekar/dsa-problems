// Link to problem - https://leetcode.com/problems/equal-row-and-column-pairs/description/

/**
 * Intuition - Iterate through all rows and columns separately and store them as strings in maps.
 * Iterate through row maps and verify if such an entry exists in col map. If yes, then multiply
 * the count of row and col map values as they could contain multiple rows and columns with same
 * order of elements.
 *
 * Time complexity - O(n^2)
 * Space complexity - O(n)
 */
class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> rows = new HashMap<>();
        Map<String, Integer> cols = new HashMap<>();
        int count = 0;

        for(int i = 0; i < grid.length; i++) {
            String row = Arrays.toString(grid[i]);
            rows.put(row, rows.getOrDefault(row, 0) + 1);
        }

        for(int i = 0; i < grid.length; i++) {
            int[] colArr = new int[grid.length];
            int k = 0;
            for(int j = 0; j < grid[i].length; j++) {
                colArr[k++] = grid[j][i];
            }
            String col = Arrays.toString(colArr);
            cols.put(col, cols.getOrDefault(col, 0) + 1);
        }

        for(Map.Entry<String, Integer> entry : rows.entrySet()) {
            String row = entry.getKey();
            int curr = 0;
            if(cols.getOrDefault(row, 0) > 0) {
                curr = entry.getValue() * cols.get(row);
            }
            count += curr;
        }

        return count;
    }
}
