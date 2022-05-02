// Link to problem - https://leetcode.com/problems/reshape-the-matrix/

/**
 * Intuition - Check if number of elements is the same in given matrix and proposed matrix.
 * If they match, iterate through given matrix such that the rows are incremented only after
 * column reaches proposed column c.
 *
 * Time complexity - O(m*n) - size of matrix
 * Space complexity - O(1)
 */
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int given = mat.length * mat[0].length;
        int reshape = r * c;
        
        if(reshape != given) {
            return mat;
        }
        
        int[][] res = new int[r][c];
        int row = 0;
        int col = 0;
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(col >= mat[0].length) {
                    col = 0;
                    row++;
                }
                res[i][j] = mat[row][col];
                col++;
            }
        }
        
        return res;
    }
}
