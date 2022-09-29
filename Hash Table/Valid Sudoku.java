// Link to problem - https://leetcode.com/problems/valid-sudoku/

/**
 * Intuition - Optimized approach
 * Scan the matrix and store the discovered elements along rows and columns
 * in one set 'seen'. Compare every element to check if it's a duplicate.
 * If not, then add to set. Otherwise, return false.
 * Elements along rows and columns are differentiated via strings as shown.
 *
 * Time complexity - O(1)
 * Space complexity - O(1)
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(!seen.add(board[i][j] + " in row " + i)
                      || !seen.add(board[i][j] + " in col " + j)
                      || !seen.add(board[i][j] + " in box " + i/3 + " " + j/3)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}


/**
 * Intuition - Brute Force approach
 * Scan the matrix and store the discovered elements along rows and columns
 * separately in sets. Compare every element to check if it's a duplicate.
 * If not, then add to set.
 * Also, check the sub-box for every element for duplicates.
 *
 * Time complexity - O(1)
 * Space complexity - O(1)
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> row = new HashSet<>();
        Set<Character> col = new HashSet<>();
        
        // Scan rows for duplicates
        for(int i = 0; i < 9; i++) {
            row.clear();
            col.clear();
            for(int j = 0; j < 9; j++) {
                // Duplicate element found along row
                if(board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }

                // Duplicate element found along column
                if(board[j][i] != '.' && !col.add(board[j][i])) {
                    return false;
                }

                // Check for duplicates in sub-boxes
                if(i >= 0 && i <= 2) {
                    if(j >= 0 && j <= 2) {
                        if(isDuplicate(board, 0, 2, 0, 2))
                            return false;
                    }
                    else if(j >= 3 && j <= 5) {
                        if(isDuplicate(board, 0, 2, 3, 5))
                            return false;
                    }
                    else {
                        if(isDuplicate(board, 0, 2, 6, 8))
                            return false;
                    }
                }
                else if(i >= 3 && i <= 5) {
                    if(j >= 0 && j <= 2) {
                        if(isDuplicate(board, 3, 5, 0, 2))
                            return false;
                    }
                    else if(j >= 3 && j <= 5) {
                        if(isDuplicate(board, 3, 5, 3, 5))
                            return false;
                    }
                    else {
                        if(isDuplicate(board, 3, 5, 6, 8))
                            return false;
                    }
                }
                else {
                    if(j >= 0 && j <= 2) {
                        if(isDuplicate(board, 6, 8, 0, 2))
                            return false;
                    }
                    else if(j >= 3 && j <= 5) {
                        if(isDuplicate(board, 6, 8, 3, 5))
                            return false;
                    }
                    else {
                        if(isDuplicate(board, 6, 8, 6, 8))
                            return false;
                    }
                }
            }
        }
        
        return true;        
    }
    
    public boolean isDuplicate(char[][] board, int top, int bottom, int left, int right) {
        Set<Character> set = new HashSet<>();
        for(int i = top; i <= bottom; i++) {
            for(int j = left; j <= right; j++) {
                if(board[i][j] != '.' && !set.add(board[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
