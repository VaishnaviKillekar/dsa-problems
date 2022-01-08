// Link to problem - https://leetcode.com/problems/single-number/

/**
 * Intuition - Do an XOR of all array elements. All pairs cancel each other - A ^ A => 0
 * Only the unique element will remain.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */

class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum = sum ^ nums[i];
        }
        return sum;
    }
}