// Link to problem - https://leetcode.com/problems/surrounded-regions/description/

/**
 * Intuition - Boundary DFS
 * Scan the first and last columns and the first and last rows for Os.
 * If an O is found, then use DFS and mark all Os with #s. This indicates
 * all Os adjacent to boundary Os cannot be flipped.
 * Now scan the board and flip all Os (not adjacent to boundary Os) to Xs.
 * And flip all #s (Os adjacent to boundary Os) back to Os.
 *
 * Time complexity - O(m * n)
 * Space complexity - O(m * n)
 */
class Solution {
    public void solve(char[][] board) {
        // Scan edge columns to find 0s that cannot be flipped
        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if(board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1);
            }
        }

        // Scan edge rows to find Os that cannot be flipped
        for(int j = 0; j < board[0].length; j++) {
            if(board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if(board[board.length - 1][j] == 'O') {
                dfs(board, board.length - 1, j);
            }
        }

        // Scan through the board and flip all Os to X and # to Os
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if(i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != 'O') {
            return;
        }
        // Mark O as this cannot be flipped
        board[i][j] = '#';

        // Also mark neighbouring Os
        dfs(board, i - 1, j);  // Top
        dfs(board, i + 1, j);  // Down
        dfs(board, i, j - 1);  // Left
        dfs(board, i, j + 1);  // Right
    }
}
