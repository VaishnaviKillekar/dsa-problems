// Link to problem - https://leetcode.com/problems/counting-bits/

/*
 * Intuition - Dynamic programming - bottom-up approach
 * Start with number 0 which has no ones. Followed by number 1 which has 1 one.
 * Ones in a number 'N' is the sum of its last bit with number of ones in number N/2.
 * E.g - Ones in number 2 = (Ones in number which is half of current number) + (Last digit in current number)
 *                        = (2 >> 1 => 1) + (2 & 1 => 1)
 *                        = 2
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i = 1; i < n+1; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }
}
