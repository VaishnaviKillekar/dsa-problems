// Link to problem - https://leetcode.com/problems/spiral-matrix/

/**
 * Intuition - Using bounding variables to track scanned rows and columns
 * Track the scanned rows and columns using top, bottom, left and right variables.
 * Iterate through the rows and columns within these bounding variables.
 *
 * Time complexity - O(mn)
 * Space complexity - O(1)
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList();
        int left = -1;
        int right = matrix[0].length;
        int top = -1;
        int bottom = matrix.length;
        int i = 0, j = 0;
        
        while(i > top && i < bottom && j > left && j < right) {
            if(!(j > left && j < right)) {
                continue;
            }
            while(j > left && j < right) {
                order.add(matrix[i][j]);
                j++;
            }
            j--;
            i++;
            top++;
            if(!(i > top && i < bottom)) {
                continue;
            }
            while(i > top && i < bottom) {
                order.add(matrix[i][j]);
                i++;
            }
            i--;
            j--;
            right--;
            if(!(j > left && j < right)) {
                continue;
            }
            while(j > left && j < right) {
                order.add(matrix[i][j]);
                j--;
            }
            j++;
            i--;
            bottom--;
            
            while(i > top && i < bottom) {
                order.add(matrix[i][j]);
                i--;
            }
            left++;
            i++;
            j++;
        }
        return order;
    }
}


/**
 * Intuition - Marking scanned elements
 * Scan through the matrix in all for directions in a sequence using the element value -1000
 * to identify if the element is already scanned.
 * First left to right -> top to bottom -> right to left -> bottom to top
 *
 * Time complexity - O(mn)
 * Space complexity - O(1)
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < matrix.length && j < matrix[0].length && matrix[i][j] != -1000) {
            // Scan left to right
            while(j < matrix[0].length && matrix[i][j] != -1000) {
                order.add(matrix[i][j]);
                matrix[i][j] = -1000;
                j++;
            }
            // Move pointer to the next element vertically
            j--;
            i++;

            // Scan top to bottom
            while(i < matrix.length && matrix[i][j] != -1000) {
                order.add(matrix[i][j]);
                matrix[i][j] = -1000;
                i++;
            }
            // Move pointer to the next element horizontally
            i--;
            j--;

            // Scan right to left
            while(j >= 0 && matrix[i][j] != -1000) {
                order.add(matrix[i][j]);
                matrix[i][j] = -1000;
                j--;
            }
            // Move pointer to the next element vertically
            i--;
            j++;

            // Scan bottom to top
            while(i >= 0 && matrix[i][j] != -1000) {
                order.add(matrix[i][j]);
                matrix[i][j] = -1000;
                i--;
            }
            // Move pointer to the next element horizontally
            j++;
            i++;
        }

        return order;
    }
}
