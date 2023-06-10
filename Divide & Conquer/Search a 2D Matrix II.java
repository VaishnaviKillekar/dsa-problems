// Link to problem - https://leetcode.com/problems/search-a-2d-matrix-ii/description/


/**
 * Intuition - Since rows and columns are individually sorted, we can take inspiration
 * from Divide & Conquer for reducing the search space.
 * Consider below 2D array with target as 16,
 * [1,  4,  7,  11, 15]
 * [2,  5,  8,  12, 19]
 * [3,  6,  9,  16, 22]
 * [10, 13, 14, 17, 24]
 * [18, 21, 23, 26, 30]
 *
 * The top-right corner element is taken as reference, here 15. Initially, the search
 * space is the entire array with 15 as reference.
 * Compare the target with the reference and reduce the search space appropriately.
 *
 * 16 > 15, top row can be removed from search space as all elements to the left of 15 
 * are smaller. Hence, the search space becomes,
 * [2,  5,  8,  12, 19]
 * [3,  6,  9,  16, 22]
 * [10, 13, 14, 17, 24]
 * [18, 21, 23, 26, 30]
 * 
 * 16 < 19, last column can be removed from search space as all elements to the bottom of
 * 19 are larger. Hence, the search space becomes,
 * [2,  5,  8,  12]
 * [3,  6,  9,  16]
 * [10, 13, 14, 17]
 * [18, 21, 23, 26]
 *
 * 16 > 12, top row can be removed from search space as all elements to the left of 12
 * are smaller. Hence, the search space becomes,
 * [3,  6,  9,  16]
 * [10, 13, 14, 17]
 * [18, 21, 23, 26]
 *
 * 16 == 16 -> target found
 *
 * Time complexity - O(m + n)
 * Space complexity - O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0;           // Row index
        int j = cols - 1;    // Column index

        // Traverse the array such that we check first row and last column with top-right corner
        // element as reference. 
        while(i < rows && j >= 0) {
            if(matrix[i][j] == target) {
                return true;
            }
            else if(matrix[i][j] < target) {
                // Increment row as all elements to the left of top-right corner element are smaller
                i++;
            }
            else {
                // Decrement column as all elements to the bottom of top-right corner element are greater
                j--;
            }
        }

        return false;
    }
}
