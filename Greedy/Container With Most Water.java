// Link to problem - https://leetcode.com/problems/container-with-most-water/

/**
 * Intuition - Use two-pointer technique to start with the first and last line. Shrink the container fro the shorter end side and
 * compare if the new area is larger than the current max one.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        
        while(i < j) {
            int currentArea = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(currentArea, maxArea);

            if(height[i] > height[j]) {
                j--;
            }
            else {
                i++;
            }
        }
        
        return maxArea;
    }
}
