// Link to problem - https://leetcode.com/problems/count-primes/

/**
 * Intuition - 
 * If we use Brute Force and check for every integer from 0 to n, then time limit is exceeded.
 * Instead, we can consider each element from 0 to n and mark all its multiples as composite.
 * So when an integer is found to be false in composite, then increment count and mark its 
 * multiples as true.
 *
 * For i = 2: we go through n/2 elements
 * For i = 3: we go through n/3 elements
 * For i = 4: skip since this is marked as composite
 * For i = 5: we go through n/5 elements
 * For i = 6: skip since this is marked as composite
 * For i = 7: we go through n/7 elements
 * ...
 * Total time taken = n/2 + n/3 + n/5 + n/7 + ...
 *                  = n(1/2 + 1/3 + 1/5 + 1/7 + ...)
 * 
 * Harmonic Progression of prime numbers which can be reduced to log(log(n))
 * Hence, time taken = n * log(log(n))
 *
 * Time complexity - O(n * log(log(n)))
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
