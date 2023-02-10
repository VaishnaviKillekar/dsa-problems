// Link to problem - https://leetcode.com/problems/unique-paths/description/

/**
 * Intuition - DP with O(m * n) space
 * Each  block can be reached from the top or left, hence compute the unique ways of
 * reaching a block by adding the number of ways from top and left.
 *
 * Time complexity - O(m * n)
 * Space complexity - O(m * n)
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];

        // Initialise each location to 1 as it is the minimum required to reach
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = 1;
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
     }
}

/**
 * Intuition - Optimised DP with O(n) space
 *
 * Time complexity - O(m * n)
 * Space complexity - O(n)
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[] = new int[n];

        for(int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
     }
}

/**
 * Intuition - Backtracking - Time Limit Exceeded error
 *
 * Increment path count when the bottom-right cell is reached. Explore all
 * possibilities for each cell by going right and bottom from it.
 *
 * Time complexity - O(n!)
 * Space complexity - O(2^n)
 */
class Solution {
    public int uniquePaths(int m, int n) {
        return countPaths(m, n, 0, 0, 0);
    }

    public int countPaths(int m, int n, int i, int j, int count) {
        // Finish reached - count path
        if(i == m - 1 && j == n - 1) {
            count++;
        }
        else {
            // Move right
            if(j < n - 1) {
                count = countPaths(m, n, i, j + 1, count);
            }

            // Move down
            if(i < m - 1) {
                count = countPaths(m, n, i + 1, j, count);
            }
        }
        return count;
    }
}
