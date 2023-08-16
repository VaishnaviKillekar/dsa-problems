// Link to problem - https://leetcode.com/problems/target-sum/description/

/**
 * Intuition - Brute Force recursive approach
 * We recurse through given array using current index and current sum. The number at
 * current index is taken once as positive and negative and recursion continues until
 * current index reaches end of array. Once index is at the end of array, check if sum
 * is same as target. If yes, increment count. Backtrack from there as there is no
 * array left to scan further.
 *
 * Time complexity - O(2^n) - every number (n) is taken once as positive and negative
 * Space complexity - O(n) - depth of recursion tree
 */
class Solution {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        findWays(nums, target, 0, 0); 
        return count;
    }

    public void findWays(int[] nums, int target, int sum, int index) {
        if(index == nums.length) {
            if(sum == target) {
                count++;
            }
            return;
        }

        findWays(nums, target, sum + nums[index], index + 1);
        findWays(nums, target, sum - nums[index], index + 1);
    }
}
