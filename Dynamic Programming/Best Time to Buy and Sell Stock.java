// Link to problem - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

/**
 * Concise solution
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int low = 0;
        
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] - prices[low] > profit) {
                profit = prices[i] - prices[low];
            }
            if(prices[i] < prices[low]) {
                low = i;
            }
        }
        
        return profit;
    }
}


/**
 * Intuition - If there are only two elements in the array, then the max profit is prices[1] - prices[0], if prices[1] > prices[0]. Otherwise, 0.
 * Maintain a minimum element 'min' which is the lowest one read so far.
 * After scanning a new element, compare its difference with min and existing max profit. If it is higher, update the max profit.
 *
 * Time complexity - O(n)
 * Space complexity - O(n) - reduce to O(1) by using two variables for dp[i] and dp[i-1]
 */
class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int min = -1;
        
        if(prices.length < 2) {
            return 0;
        }
        
        dp[0] = 0;
        if(prices[0] < prices[1]) {
            min = 0;
            dp[1] = prices[1] - prices[0];
        }
        else {
            min = 1;
            dp[1] = 0;
        }
        
        for(int i = 2; i < dp.length; i++) {
            if(prices[i] - prices[min] > dp[i-1]) {
                dp[i] = prices[i] - prices[min];
            }
            else {
                dp[i] = dp[i-1];
            }
            if(prices[i] < prices[min]) {
                min = i;
            }
        }
        
        return dp[prices.length-1];
    }
}
