// Link to problem - https://leetcode.com/problems/set-matrix-zeroes/

/**
 * Intuition - Track the rows and columns that need to reset to zero by marking
 * the first row and first column of the zero's position.
 * Since [0][0] position is common for first row and column, we use a separate
 * variable `colZero` to determine if the first column contains a zero, so that
 * [0][0] indicates if the first row contains zeroes.
 *
 * After marking the first row and column positions, iterate the matrix from the
 * bottom-right corner and check if the first row and first column of the current
 * element are zero. If yes, reset current element to zero.
 * At the end of every row iteration, check if `colZero` is true, and set the first
 * column element to zero.
 *
 * Time complexity - O(m * n)
 * Space complexity - O(1)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean colZero = false;

        // Mark the 0th cell of that row and column as zero where a zero is found
        for(int i = 0; i < matrix.length; i++) {
            // Check if 0th column contains zeroes
            if(matrix[i][0] == 0) {
                colZero = true;
            }
            // 0th column is skipped - colZero serves as column marker and j = 0 serves as a row marker
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        // Set zeroes based on markers at the 0th row and 0th column
        for(int i = matrix.length - 1; i >= 0; i--) {
            for(int j = matrix[0].length - 1; j >= 1; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            // If 0th column contains zero, mark 0th column of current row
            if(colZero) {
                matrix[i][0] = 0;
            }
        }
    }
}


/**
 * Intuition - Store the columns which contain zeroes in a TreeSet.
 * Iterate through the matrix and when a zero is found, reset the entire row to zero.
 *
 * Now re-iterate through the matrix and set the columns as zero using the TreeSet.
 *
 * Time complexity - O(m * n)
 * Space complexity - O(n)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> cols = new TreeSet();

        for(int i = 0; i < matrix.length; i++) {
            boolean flag = false;
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    flag = true;
                    cols.add(j);
                }
            }
            if(flag) {
                matrix[i] = new int[matrix[0].length];
            }
        }

        for(int j : cols) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
            j++;            
        }
    }
}
