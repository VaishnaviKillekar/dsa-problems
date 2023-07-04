// Link to problem - https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

/**
 * Intuition - Binary Search can be applied by considering weight as a sorted array
 * where min = 0 and max = total sum of all weights in weights array. This is a 
 * minimisation problem where we constantly check if mid is a possible solution.
 * If yes, then we further narrow down our range using binary search and recomputing
 * mid and continue this until all weights can't be shipped in given days.
 * If no, then we increase the ship's capacity and do so until we find a threshold
 * where all weights can be shipped in given days by narrowing search to right side
 * i.e., increasing weight range.
 * 
 * Consider weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * Here, min = 0 and max = 55 initially.
 * min = 0, max = 55, mid = 27
 *  day 1 = [1,2,3,4,5,6] -> 21
 *  day 2 = [7,8,9]       -> 24
 *  day 3 = [10]          -> 10
 * This is a possible solution.
 * Since weights can be shipped within 5 days with ship capacity as 27 (mid), we can
 * further reduce capacity and check if it is possible to ship all weights
 *
 * min = 0, max = 26, mid = 13
 *  day 1 = [1,2,3,4]  -> 10
 *  day 2 = [5,6]      -> 11
 *  day 3 = [7]        -> 7
 *  day 4 = [8]        -> 8
 *  day 5 = [9]        -> 9
 * 10 is left out. Hence, this is not a possible solution and we need to increase ship capacity.
 *
 * min = 14, max = 26, mid = 15
 *  day 1 = [1,2,3,4,5]  -> 15
 *  day 2 = [6,7]        -> 15
 *  day 3 = [8]          -> 8
 *  day 4 = [9]          -> 9
 *  day 5 = [10]         -> 10
 * This is a possible solution. minWeight = 15
 *
 * min = 14, max = 14, mid = 7
 *  day 1 = [1,2,3]  -> 6
 *  day 2 = [4]      -> 4
 *  day 3 = [5]      -> 5
 *  day 4 = [6]      -> 6
 *  day 5 = [7]      -> 7
 * This is not a possible solution. Increase ship capacity.
 *
 * min = 8, max = 14, mid = 11
 *  day 1 = [1,2,3,4]  -> 10
 *  day 2 = [5,6]      -> 11
 *  day 3 = [7]        -> 7
 *  day 4 = [8]        -> 8
 *  day 5 = [9]        -> 9
 * This is not a possible solution. Increase ship capacity.
 *
 * min = 12, max = 14, mid = 13
 *  day 1 = [1,2,3,4]  -> 10
 *  day 2 = [5,6]      -> 11
 *  day 3 = [7]        -> 7
 *  day 4 = [8]        -> 8
 *  day 5 = [9]        -> 9
 * This is not a possible solution. Increase ship capacity.
 *
 * min = 14, max = 14, mid = 14
*  day 1 = [1,2,3,4]  -> 10
 *  day 2 = [5,6]      -> 11
 *  day 3 = [7]        -> 7
 *  day 4 = [8]        -> 8
 *  day 5 = [9]        -> 9
 * This is not a possible solution. Increase ship capacity.
 *
 * min = 15, max = 15 ==> min > max, hence terminate loop.
 * minWeight = 15
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0;
        int max = 0;

        // Get total weight
        for(int i = 0; i < weights.length; i++) {
            max += weights[i];
        }

        int minWeight = max;
        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(isPossible(weights, days, mid)) {
                minWeight = mid;
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }

        return minWeight;
    }

    public boolean isPossible(int[] weights, int days, int mid) {
        int i = 0;  // Current weight

        // Assign weights per day
        for(int day = 1; day <= days; day++) {
            int curr = 0;
            while(i < weights.length && curr + weights[i] <= mid) {
                curr += weights[i];
                i++;
            }
        }
        if(i == weights.length) {
            // Shipped all weights
            return true;
        }
        return false;
    }
}
