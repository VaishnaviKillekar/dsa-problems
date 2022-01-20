// Link to problem - https://leetcode.com/problems/min-cost-climbing-stairs/

/**
 * Intuition - From every stair, we can either move forward one stair or two stairs. Every ith stair can be reached by 
 * either the stair immediately behind it (i-1) or the stair behind its previous (i-2).
 * We also need to consider the minimum cost among the last stair and the last but one stair for final minimum.
 * There is only one way to climb to stair 1 and stair 2 which their actual cost itself. These form the base cases.
 *
 * Recurrence relation: dp[i] = Min(cost[i] + dp[i-1], cost[i] + dp[i-2])
 * Base cases:
 *            dp[0] = cost[0]
 *            dp[1] = cost[1]
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
 class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        if(cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        
        int i;
        for(i = 2; i < cost.length; i++) {
            dp[i] = Math.min(cost[i] + dp[i-2], cost[i] + dp[i-1]);
        }
        dp[i] = Math.min(dp[i-2], dp[i-1]);
        
        return dp[cost.length];
    }
}
