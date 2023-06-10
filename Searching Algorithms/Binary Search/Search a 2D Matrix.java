// Link to problem - https://leetcode.com/problems/search-a-2d-matrix/description/


/**
 * Intuition - Since the given array is sorted both row-wise and column-wise, it
 * can be treated as a 1D sorted array and Binary Search can be used to search
 * the target.
 * To get equivalent position of 'mid' in 2D array, compute as below using row 
 * length:
 * i = mid / matrix[0].length
 * j = mid % matrix[0].length
 *
 * Time complexity - O(log(m * n))
 * Space complexity - O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            // Relative position of mid in 2D arrray
            int i = mid / matrix[0].length;
            int j = mid % matrix[0].length;

            if(matrix[i][j] == target) {
                return true;
            }
            else if(matrix[i][j] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return false;
    }
}
