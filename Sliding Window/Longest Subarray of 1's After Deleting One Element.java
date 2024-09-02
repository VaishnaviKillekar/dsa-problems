// Link to problem - https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75

/**
 * Intuition - Iterate through array and track the index of first zero encountered. Compute
 * max after every update to the sliding window pointers. If a second zero is found, then
 * reset the left of the window to the position next to first zero.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int zeroIndex = -1;
        int max = 0;

        while(right < nums.length) {
            if(nums[right] == 1) {
                right++;
                max = Math.max(max, right - left - 1);
            }
            else if(zeroIndex == -1) {
                // First zero - delete and proceed
                zeroIndex = right;
                right++;
                max = Math.max(max, right - left - 1);
            }
            else {
                // Second zero. Reset left to position after first zero
                max = Math.max(max, right - left - 1);
                left = zeroIndex + 1;
                zeroIndex = -1;
            }
        }

        return max;
    }
}
