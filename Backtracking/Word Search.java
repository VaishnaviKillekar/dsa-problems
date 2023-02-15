// Link to problem - https://leetcode.com/problems/word-search/description/

/**
 * Intuition - Backtracking with Brute Force approach
 *
 * Scan through the matrix 'board' until the first character of 'word' is found.
 * On a match, call the recusrive, backtracking function to search the rest of
 * the word. There are 4 directions for searching - top, bottom, left & right.
 * To avoid using a character twice, 'visited' martix tracks all characters that
 * have been considered for the word search at that point.
 *
 * On jumping to a new position on board, mark the position as visited, if the
 * current character is a match in the current position of the word. Now search
 * the four directions for the remaining word. If none of the directions contain
 * the remaining part of the word, the current board position is marked as NOT
 * visited and we backtrack.
 *
 * Time complexity - O(m^2 * n^2) - confirm
 * Space complexity - O(m^2 * n^2) - confirm
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        // Word to be found is longer than total characters on board
        if(word.length() > (board.length * board[0].length)) {
            return false;
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0) && findWord(board, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findWord(char[][] board, boolean[][] visited, String word, int i, int j, int curr) {
        // Check if the current character in word is a match
        if(board[i][j] != word.charAt(curr)) {
            return false;
        }

        // Mark current position as visited
        visited[i][j] = true;

        // Check if word has been found
        if(board[i][j] == word.charAt(curr) && curr == word.length() - 1) {
            return true;
        }
        
        boolean found = false;

        // Search top
        if(i > 0 && !visited[i - 1][j]) {
            found = findWord(board, visited, word, i - 1, j, curr + 1);
        }
        // Search left
        if(j > 0 && !visited[i][j - 1] && !found) {
            found = findWord(board, visited, word, i, j - 1, curr + 1);
        }
        // Search bottom
        if(i < board.length - 1 && !visited[i + 1][j] && !found) {
            found = findWord(board, visited, word, i + 1, j, curr + 1);
        }
        // Search right
        if(j < board[0].length - 1 && !visited[i][j + 1] && !found) {
            found = findWord(board, visited, word, i, j + 1, curr + 1);
        }

        // Mark current position as NOT visited
        visited[i][j] = false;

        return found;
    }
}
