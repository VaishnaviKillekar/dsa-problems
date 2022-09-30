// Link to problem - https://leetcode.com/problems/rotate-image/

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
