// Link to problem - https://leetcode.com/problems/maximal-rectangle/description/

/**
 * Intuition - Use the Largest Rectangle in Histogram solution logic [https://github.com/VaishnaviKillekar/dsa-problems/blob/main/Stacks/Largest%20Rectangle%20in%20Histogram.java]
 * Here, we find the maximum area for the first row and then move on to subsequent rows by adding the previous row
 * and computing maximum area again. This is done for all remaining rows.
 *
 * Time complexity - O(n * m)
 * Space complexity - O(n * m) - due to int matrix created. Otherwise, O(cols) - stack
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int[][] heights = new int[matrix.length][matrix[0].length];

        // Get the integer version of the char matrix
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                heights[i][j] = Character.getNumericValue(matrix[i][j]);
            }
        }

        // First find the maximum area of first row
        max = getCurrentMax(heights, 0);

        // Now add the 1s of subsequent rows to form heights.
        // Ignore the entire column if the element is zero at current row since base can't be zero
        for(int i = 1; i < heights.length; i++) {
            for(int j = 0; j < heights[0].length; j++) {
                // Add height of previous row only if current is not zero
                if(heights[i][j] != 0) {
                    heights[i][j] = heights[i][j] + heights[i - 1][j];
                }
            }

            // Compute max area for current heights - use logic from Max Rectangle in Histogram problem
            max = Math.max(max, getCurrentMax(heights, i));
        }

        return max;
    }

    public int getCurrentMax(int[][] heights, int row) {
        int[] prev = getPrevSmallerElements(heights, row);
        int[] next = getNextSmallerElements(heights, row);
        int area = 0;

        for(int j = 0; j < heights[0].length; j++) {
            if(heights[row][j] != 0) {
                if(next[j] == -1) {
                    next[j] = heights[0].length;
                }
                int len = heights[row][j];
                int width = next[j] - prev[j] - 1;
                area = Math.max(area, len * width);
            }
        }

        return area;
    }

    public int[] getPrevSmallerElements(int[][] heights, int row) {
        int[] prev = new int[heights[0].length];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int j = 0; j < heights[0].length; j++) {
            while(stack.peek() != -1 && heights[row][stack.peek()] >= heights[row][j]) {
                stack.pop();
            }
            prev[j] = stack.peek();
            stack.push(j);
        }

        return prev;
    }

    public int[] getNextSmallerElements(int[][] heights, int row) {
        int[] next = new int[heights[0].length];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int j = heights[0].length - 1; j >= 0; j--) {
            while(stack.peek() != -1 && heights[row][stack.peek()] >= heights[row][j]) {
                stack.pop();
            }
            next[j] = stack.peek();
            stack.push(j);
        }

        return next;
    }
}
