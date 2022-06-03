// Link to problem - https://leetcode.com/problems/range-sum-query-2d-immutable/

/**
 * Intuition - Brute force approach only works for smaller inputs. Hence, caching or storing computed data is necessary.
 * We can store the result in a 2D matrix 'dp'. This matrix will hold the values of the sum for those coordinates from origin.
 * E.g. the sum of all elements in rectangle formed within [0,0] and [r,c] will be available in dp[r+1][c+1].
 * Now since the rectangle's top left corner need not be origin, we can substract the additional area lying outside the
 * rectangle from the required bottom right corner of rectangle [r,c]. Refer to the solution in problem link.
 *
 * Time complexity - O(mn) for pre-computing 'dp' matrix. O(1) for finding sum of any rectangle.
 * Space complexity - O(mn)
 */
class NumMatrix {

    int[][] matrix;
    int[][] dp;
    
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;   
        this.dp = new int[matrix.length+1][matrix[0].length+1];
        compute(matrix, dp);
    }
    
    public void compute(int[][] matrix, int[][] dp) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                dp[i+1][j+1] = matrix[i][j] - dp[i][j] + dp[i+1][j] + dp[i][j+1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
