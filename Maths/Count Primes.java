// Link to problem - https://leetcode.com/problems/count-primes/

/**
 * Intuition - 
 * If we use Brute Force and check for every integer from 0 to n, then time limit is exceeded.
 * Instead, we can consider each element from 0 to n and mark all its multiples as composite.
 * So when an integer is found to be false in composite, then increment count and mark its 
 * multiples as true.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] composite = new boolean[n];
        
        for(int i = 2; i < n; i++) {
            // Mark all multiples of i as true
            if(!composite[i]) {
                count++;
                for(int j = 2; i * j < n; j++) {
                    composite[i * j] = true;
                }
            }
        }
        
        return count;
    }
}
