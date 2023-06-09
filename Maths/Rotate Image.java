// Link to problem - https://leetcode.com/problems/rotate-image/

/**
 * Intuition - Transpose the matrix and then reverse elements in each row.
 *
 * Time complexity - O(n^2)
 * Space complexity - O(1)
 */
class Solution {
    public void rotate(int[][] matrix) {
        // Transpose the given matrix
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i; j < matrix[0].length; j++) {
                if(i != j) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
            }
        }

        // Reverse the rows of transposed matrix
        for(int i = 0; i < matrix.length; i++) {
            int j = 0;
            int k = matrix[0].length - 1;
            while(j < k){
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = t;
                j++;
                k--;
            }
        }
    }
}


/**
 * Intuition - Flip the matrix upside down and then transpose it.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Flip matrix upside down
        int top = 0;
        int bottom = n - 1;
        while(top < bottom) {
            int[] temp = matrix[top];
            matrix[top++] = matrix[bottom];
            matrix[bottom--] = temp;
        }
        
        // Transpose the matrix
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
