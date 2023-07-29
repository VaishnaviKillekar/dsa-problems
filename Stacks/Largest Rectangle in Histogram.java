// Link to problem - https://leetcode.com/problems/largest-rectangle-in-histogram/

/**
 * Intuition - Use the Next Smaller Element solution to find the previous and next index
 * to where the width can be extended from current element. i.e., if we are inedx i, then
 * we can stretch the width to the left and right as long as the heights are greather than
 * or equal to current height.
 * Once the 'next' and 'prev' arrays are formed, we use the formula to compute width at each
 * index, width = next - prev - 1 for current element.
 * If next = -1, this means that the current height is smallest and hence the width can be
 * expanded to the entire array. Consider [2,2,2] for example.
 *
 * Test Cases - 
 * [2,1,5,6,2,3]
 * [2,4]
 * [0]
 * [2,1,2]
 * [1,2,2]
 * [2,2,2]
 * [1,2,3,4,5]
 * [5,4,3,2,1]
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;

        int[] next = getNextSmallerElements(heights);
        int[] prev = getPrevSmallerElements(heights);

        for(int i = 0; i < n; i++) {
            // All elements are equal [2,2,2] so width can be extended to the end of array
            if(next[i] == -1) {
                next[i] = n;
            }

            int len = heights[i];
            int width = next[i] - prev[i] - 1;

            maxArea = Math.max(maxArea, len * width);
        }

        return maxArea;
    }

    public int[] getNextSmallerElements(int[] heights) {
        int[] next = new int[heights.length];
        Stack<Integer> stack = new Stack<>();  // Holds the index

        // Last element has no next smaller element
        stack.push(-1);

        for(int i = heights.length - 1; i >= 0; i--) {
            // Since stack holds the index, compare with value using heights
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            next[i] = stack.peek();
            stack.push(i);
        }

        return next;
    }

    public int[] getPrevSmallerElements(int[] heights) {
        int[] prev = new int[heights.length];
        Stack<Integer> stack = new Stack<>();  // Holds the index

        // First element has no previous smaller element
        stack.push(-1);

        for(int i = 0; i < heights.length; i++) {
            // Since stack holds the index, compare with value using heights
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            prev[i] = stack.peek();
            stack.push(i);
        }

        return prev;
    }
}
