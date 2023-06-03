// Link to problem - https://leetcode.com/problems/reverse-integer/

/**
 * Intuition - Use regular reverse number technique.
 * Check if current reversed number is outside the integer range. To do so,
 * we need to check the condition where (rev * 10) must lie in the integer
 * range before we reverse the current digit.
 *
 * Now since there is a possibility of overflow/underflow on multiplication
 * with 10. We can change the condition to (rev > MAX / 10) or (rev < MIN / 10)
 * then return 0. Otherwise, continue with reverse.
 *
 * Time complexity - O(1)
 * Space complexity - O(1)
 */
class Solution {
    public int reverse(int x) {
        int rev = 0;

        while(x != 0) {
            int digit = x % 10;
            if(rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            rev = rev * 10 + digit;
            x /= 10;
        }

        return rev;
    }
}

/**
 * Intuition - Use regular reverse number technique.
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
