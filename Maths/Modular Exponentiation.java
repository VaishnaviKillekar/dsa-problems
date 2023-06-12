// Link to problem - https://www.codingninjas.com/codestudio/problems/modular-exponentiation_1082146

/**
 * Intuition - Since x and n can be very large and cause an overflow during multiplication,
 * they are stored in long variable type. 
 * Instead of multiplying x by n times, we can reduce it to -
 * (x ^ n/2)^2        -> n is even
 * (x ^ n/2)^2 * x    -> n is odd
 *
 * Time complexity - O(log(n))
 * Space complexity - O(1)
 */
public class Solution {
    public static int modularExponentiation(int x, int n, int m) {
        long result = 1L;
        long xx = x;

        while(n > 0) {
            if(n % 2 == 1) {
                // n is odd
                result = (result * (xx % m)) % m;
            }
            xx = ((xx % m) * (xx % m)) % m;
            n = n >> 1;     // Divide by 2
        }

        return (int) result;     
    }
}
