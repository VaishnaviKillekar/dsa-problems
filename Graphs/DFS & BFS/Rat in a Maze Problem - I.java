// Link to problem - https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

/**
 * Intuition - DFS with backtracking
 * From each cell, we check if the top, bottom, left and right positions are safe to visit.
 * If yes, then we add that direction to current path and explore that direction until we
 * reach the last cell.
 *
 * Time complexity - O(2 ^ (n ^ 2)) - n^2 elements in matrix and we either include or exclude so 2 possibilities per position
 * Space complexity - O(n^2) - visited matrix, n - maximum height of recursion tree
 */
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> paths = new ArrayList<>();
        int[][] visited = new int[n][n];
        
        if(m[0][0] == 0) {
            // Can't travel through first cell - no paths possible
            return paths;
        }
        
        findPaths(m, n, paths, visited, "", 0, 0);
        return paths;
    }
    
    public static void findPaths(int[][] m, int n, ArrayList<String> paths, int[][] visited, String curr, int i, int j) {
        // Reached the last cell, add curr to path
        if(i == n - 1 && j == n - 1) {
            paths.add(new String(curr));
            return;
        }
        
        // Mark cell as visited
        visited[i][j] = 1;
        
        // DFS
        if(isSafeToVisit(m, n, visited, i + 1, j)) {
            curr += "D";
            findPaths(m, n, paths, visited, curr, i + 1, j);    // Bottom
            curr = curr.substring(0, curr.length() - 1);   
        }

        if(isSafeToVisit(m, n, visited, i, j + 1)) {
            curr += "R";
            findPaths(m, n, paths, visited, curr, i, j + 1);    // Right
            curr = curr.substring(0, curr.length() - 1);   
        }
        
        if(isSafeToVisit(m, n, visited, i, j - 1)) {
            curr += "L";
            findPaths(m, n, paths, visited, curr, i, j - 1);    // Left
            curr = curr.substring(0, curr.length() - 1);   
        }
        
        if(isSafeToVisit(m, n, visited, i - 1, j)) {
            curr += "U";
            findPaths(m, n, paths, visited, curr, i - 1, j);    // Top
            curr = curr.substring(0, curr.length() - 1);   
        }
        
        // Mark cell as not visited for other paths
        visited[i][j] = 0;
    }
    
    public static boolean isSafeToVisit(int[][] m, int n, int[][] visited, int i, int j) {
        if(i < 0 || i >= n || j < 0 || j >= n) {
            return false;
        }
        
        // This cell is blocked or already visited
        if(m[i][j] == 0 || visited[i][j] == 1) {
            return false;
        }
        
        return true;
    }
}
