
// Link to problem - https://leetcode.com/problems/move-zeroes/

/**
 * Intuition - Check for non-zero elements by scanning the array from start to end.  
 * When a non-zero element is found, replace the array element at 'nonZero' index 
 * with current non-zero element and incremement the 'nonZero' counter. Element is
 * replaced irrespective of the element at 'nonZero' index.
 * In this way, we move all non-zero elements to the left and the position of 
 * 'nonZero' index will be the last non-zero element. We then replace all positions
 * after it as zero.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int nonZero = 0;
        
        // Shift all non-zero elements to the left
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[nonZero++] = nums[i];
            }
        }
        
        // Add zeroes to the right end
        for(int i = nonZero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
