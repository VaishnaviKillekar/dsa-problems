// Link to problem - https://leetcode.com/problems/power-of-three/

/**
 * Intuition - Use the logarithm-exponent property
 * 3^n = ln(n) / ln(3)
 * where, ln is log to base 10.
 *
 * This valus is rounded so it determines if n is a result of an integer power of 3.
 *
 * Time complexity - O(1)
 * Space complexity - O(1)
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 0) {
            return false;
        }
        return n == Math.pow(3, Math.round(Math.log(n) / Math.log(3)))? true : false;
    }
}
