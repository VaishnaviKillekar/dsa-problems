// Link to problem - https://leetcode.com/problems/majority-element/

/**
 * Intuition - This problem can be solved using Moore's Voting Algorithm.
 * Start with first number as the 'highest' and its count set to 1. Continue scanning the array from 2nd position.
 * If the current element is the same as 'highest', then increment count by 1. Otherwise, decrement count by 1.
 * If count becomes 0, then current element is set as 'highest' and the count is reset to 1.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int majorityElement(int[] nums) {
        int highest = nums[0];
        int count = 1;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == highest) {
                count++;
            }
            else {
                if(count == 1) {
                    highest = nums[i];
                }
                else {
                    count--;
                }
            }
        }
        
        return highest;
    }
}
