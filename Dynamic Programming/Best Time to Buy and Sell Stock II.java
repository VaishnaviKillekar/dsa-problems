// Link to problem - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

/**
 * DP approach - Trace below examples to understand the conditions in code.
 * E.g:
 *    [7,2,5,6,8,6]
 *    [7,2,5,3,9,6]
 *    [7,2,5,5,11,6]
 *    [1,2,3,4,5]
 *    [7,6,4,3,1]
 *    [1,0,5,4,8,10]
 *
 * Time complexity - O(n)
 * Space complexity - O(n) - can be reduced to O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int low = prices[0];
        int high = prices[0];
        int profitSoFar = 0;
        int[] profit = new int[prices.length];

        for(int i = 1; i < prices.length; i++) {
            // Current element is lower than low & is greater than previous element
            if(prices[i] < low && prices[i] > prices[i-1]) {
                low = prices[i];
                high = prices[i];
                profit[i] = Math.max(profit[i-1], high - low);
            }
            // Current element is greater than high
            else if(prices[i] >= high) {
                high = prices[i];
                profit[i] = Math.max(profit[i-1], high - low);
            }
            // Current element is less than previous
            else {
                profitSoFar += (high - low);
                low = prices[i];
                high = prices[i];
                profit[i] = high - low;
            }
        }

        return profitSoFar + profit[prices.length-1];
    }
}

/**
 * Greedy approach - 
 * Compare current price with previous day.
 * If current > previous -> add to profit. Else, ignore
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    
    
 public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 1; i < prices.length; i++) {
            if (prices[i-1] < prices[i]) {
                res += prices[i] - prices[i-1]; 
            }
        }
        return res;
    }
}
