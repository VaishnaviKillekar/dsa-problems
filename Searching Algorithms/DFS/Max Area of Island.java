// Link to problem - https://leetcode.com/problems/max-area-of-island/solution/

/**
 * Intuition - DFS
 * Scan through the grid and when a 1 is found, check if it is being visited for the
 * first time. If yes, then do a DFS search to get all surrounding 1s.
 * DFS is carried out on non-zero elements which are in positions - top, bottom, left
 * and right. Mark the 1s as visited when DFS is called on them.
 * Increment size of island when DFS is invoked.
 *
 * After all elements are searched, check if size of island is greater than current
 * max. Reset if yes.
 *
 * Time complexity - O(m*n)
 * Space complexity - O(m*n)
 */
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int visited[][] = new int[grid.length][grid[0].length];
        int max = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) {
                    int size = dfs(grid, visited, i, j, 0);
                    max = size > max ? size : max;
                }
            }
        }
        
        return max;
    }
    
    public int dfs(int[][] grid, int visited[][], int i, int j, int size) {
        if(visited[i][j] == 1) {
            return size;
        }
        visited[i][j] = 1;
        size++;
        // Check Top
        if(i - 1 >= 0 && grid[i-1][j] == 1 && visited[i-1][j] == 0) {
            size = dfs(grid, visited, i - 1, j, size);
        }
        // Check Bottom
        if(i + 1 < grid.length && grid[i+1][j] == 1 && visited[i+1][j] == 0) {
            size = dfs(grid, visited, i + 1, j, size);
        }
        // Check Left
        if(j - 1 >= 0 && grid[i][j-1] == 1 && visited[i][j-1] == 0) {
            size = dfs(grid, visited, i, j - 1, size);
        }
        // Check Right
        if(j + 1 < grid[0].length && grid[i][j+1] == 1 && visited[i][j+1] == 0) {
            size = dfs(grid, visited, i, j + 1, size);
        }
        return size;
    }
}
