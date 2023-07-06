// Link to problem - https://leetcode.com/problems/koko-eating-bananas/description/

/**
 * Intuition - Binary Search with computing hours to finish all piles
 * Koko can eat only one pile or a fraction of it per hour. So hours have to be at
 * least greater than or equal to number of 'piles'. Hence, we get max of piles.
 * Using Binary Search, we set the maximum limit of bananas 'mid' that can be eaten
 * in one hour. We then iterate through 'piles' and compute the hours required to
 * finish each pile including leftovers which cost separate additional hours.
 * If the computed hours <= mid, then this is a solution. We further narrow search
 * (reduce hours) space using Binary Search. If 'mid' is not a solution, then we
 * reduce search space by increasing hours.
 *
 * Consider piles = [30,11,23,4,20]   h = 5    k = 0
 * min = 0,  max = 30, mid = 15:     hours = 8  -> Not a possible solution
 * min = 16, max = 30, mid = 23:    hours = 6  -> Not a possible solution
 * min = 24, max = 30, mid = 27:    hours = 6  -> Not a possible solution
 * min = 28, max = 30, mid = 29:    hours = 6  -> Not a possible solution
 * min = 30, max = 30, mid = 30:    hours = 5  -> Possible solution  => k = 5
 *
 * Time complexity - O(nlogn) - Using Binary Search, we process array each time
 * Space complexiity - O(1)
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 0;
        int max = Integer.MIN_VALUE;
        int k = 0;      // Minimum bananas per hour to finish all in h hours

        // Maximum bananas that can be eaten in an hour
        for(int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        // Use Binary Search to find minimum bananas that can be eaten in an hour
        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(isPossible(piles, h, mid)) {
                // mid no. of bananas can finished in h hours
                k = mid;
                max = mid - 1;
            }
            else {
                // bananas per hour need to be increased to finish all
                min = mid + 1;
            }
        }

        return k;
    }

    public boolean isPossible(int[] piles, int h, int mid) {
        if(mid == 0) {
            return false;
        }

        int hours = 0;      // Hours required to finish bananas at speed h per hour
        for(int pile : piles) {
            hours += (pile / mid);
            if(pile % mid > 0) {
                hours++;
            }
        }

        return hours <= h;
    }
}
