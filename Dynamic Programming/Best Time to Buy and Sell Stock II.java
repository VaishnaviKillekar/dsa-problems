// Link to problem - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

/**
 * Intuition - Concise DP with O(1) space
 * 'low' and 'high' track the lowest and highest seen price of the stock so far respectively. 
 * Initially start with zero profit assuming the stock was bought and sold on day one.
 * Scan through prices from day 2 and check if the current price is lower than 'low' and reset
 * 'low' to current price. 
 * Else if current price is >= 'high', reset 'high' to current price.
 * On resetting high, check if the next price is higher than today -
 *  Yes - than go to next day price
 *  No - compute profit (since price falls and we can buy stock next day and sell today)
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;  // zero profit
        int low = prices[0];
        int high = -1;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] <= low) {
                low = prices[i];
            }
            else if(prices[i] >= high) {
                high = prices[i];
                if((i + 1 < prices.length && prices[i + 1] < prices[i]) || (i + 1 == prices.length)) {
                    // Next price is lower than today so sell
                    total += (high - low);
                    low = Integer.MAX_VALUE;
                    high = -1;
                }
            }
        }

        return total;
    }
}


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
