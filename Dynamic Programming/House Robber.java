// Link to problem - https://leetcode.com/problems/house-robber/

/**
 * Intuition - Since only alternate houses can be robbed, we maximize the money by either robbing the current house i, or previous house i-1.
 * If we rob previous house i-1, then that will continue remain the total money made so far. If we rob the current house, then the money from
 * house is not included and only the money made so far till house i-2 along with money in current house is summed.
 * 
 * Recurrence relation - money[i] = Max(money[i-1], nums[i] + money[i-2])
 * Base cases - If there's only one house, then it needs to be robbed. If there are only 2 houses, then one with highest money is to be robbed.
 *              money[0] = nums[0]
 *              money[1] = Max(nums[0], nums[1])
 *
 * Time complexity - O(n)
 * Space complexity - O(n) - can be reduced to O(1) using 2 variables: prev (i-1) and previousOfPrev (i-2)
 */
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        
        int money[] = new int[nums.length];
        money[0] = nums[0];
        money[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < nums.length; i++) {
            money[i] = Math.max(nums[i] + money[i-2], money[i-1]);
        }
        
        return money[nums.length - 1];
    }
}

// Initialize DP array when no houses are available and with one house
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        
        for(int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(nums[i-1] + dp[i-2], dp[i-1]);
        }
        
        return dp[nums.length];
    }
}
