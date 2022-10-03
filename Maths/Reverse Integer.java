// Link to problem - https://leetcode.com/problems/reverse-integer/

/**
 * Intuition - Use normal reverse number technique.
 * Check if current reversed number overflows - if after
 * removing added digit it is same as previous, then there
 * is no overflow. Otherwise, return 0.
 *
 * Time complexity - O(1)
 * Space complexity - O(1)
 */
class Solution {
    public int reverse(int x) {
        int rev = 0;
        
        while(x != 0) {
            int digit = x % 10;
            int curr = (rev * 10) + digit;
            if((curr - digit) / 10 != rev) {
                return 0;
            }
            rev = curr;
            x /= 10;
        }
        
        return rev;
    }
}
