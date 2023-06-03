// Link to problem - https://leetcode.com/problems/power-of-two/

/**
 * Intuition - Use log to find if the number 'n' is a power of 2.
 * In Java, there is no built-in function to find log base 2 so use
 * Math.log(n) which calculates log to the base e.
 *
 * logn (base 2) = logn (base e) / log 2 (base 2)
 *
 * If 2 powered to the result matches, then it is a power of 2 -> true
 *
 * Time complexity - O(1)
 * Space complexity - O(1)
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) {
            return false;
        }
        int log = (int) (Math.log(n) / Math.log(2));
        return Math.pow(2, log) == n ? true : false;
    }
}


/**
 * Intuition - Divide given number by 2 and compare if remainder is not zero.
 * if remainder is zero, then continue dividing the number until it is not 0 or 1.
 * If the number is equal to 1 at the end, then it is a power of 2.
 *
 * Time complexity - O(1)
 * Space complexity - O(1)
 */
class Solution {
    public boolean isPowerOfTwo(int n) {

        while(n != 0 && n != 1) {
            if(n % 2 != 0) {
                return false;
            }
            n = n / 2;
        }

        return n == 1;
    }
}
