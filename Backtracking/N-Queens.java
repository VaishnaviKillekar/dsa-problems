// Link to problem - https://leetcode.com/problems/n-queens/description/

/**
 * Intuition - Place one queen in every row and no other queens can be placed along the
 * same column, left or right diagonal throughout the board (not just intermediate neighbours).
 * First validate if the queen can be safely placed at a position in a row using above conditions.
 * Since we place queens starting at row 0, we can simply verify the above conditions in the rows
 * above the current row.
 *
 * Time complexity - O(n!) - can be optimised by reducing search time along diagonals. Verify this again
 * Space complexity - O(n)
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        boolean[] usedCols = new boolean[n];

        // Create empty board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        placeQueens(n, solutions, board, usedCols, 0);
        return solutions;
    }

    public void placeQueens(int n, List<List<String>> solutions, char[][] board, boolean[] usedCols, int i) {
        // Add current placement to solution
        if(i == n) {
            List<String> solution = new ArrayList<>();
            for(int k = 0; k < n; k++) {
                solution.add(new String(board[k]));
            }
            solutions.add(solution);
            return;
        }

        // Check if queen can be placed at board[i][j]
        for(int j = 0; j < n; j++) {
            if(isSafe(n, board, usedCols, i, j)) {
                // Queen can be placed at this position
                board[i][j] = 'Q';
                usedCols[j] = true;

                // Place next queen
                placeQueens(n, solutions, board, usedCols, i + 1);

                // Check if queen can be placed in a new position
                board[i][j] = '.';
                usedCols[j] = false;
            }
        }
    }

    public boolean isSafe(int n, char[][] board, boolean[] usedCols, int i, int j) {
        // No other queen can lie in the same column
        if(usedCols[j]) {
            return false;
        }
        // No other queen can lie in the entire top left diagonal
        for(int row = i - 1, col = j - 1; row >= 0 && col >= 0; row--, col--) {
            if(board[row][col] == 'Q') {
                return false;
            }
        }
        // No other queen can lie in the entire top right diagonal
        for(int row = i - 1, col = j + 1; row >= 0 && col < n; row--, col++) {
            if(board[row][col] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
