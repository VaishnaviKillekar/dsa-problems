// Link to problem - https://leetcode.com/problems/reverse-bits/

/**
 * Intuition - Shift the given number to the right and extract its LSB.
 * Shift result to the left and add this LSB as the LSB of the result.
 * Do this for all 32 bits of the given number.
 *
 * Time complexity - O(1)
 * Space complexity - O(1)
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int lsb = n & 1;    // Get rightmost bit
            res = res << 1;     // Shift result to the left by 1 position
            res = res | lsb;    // Add the lsb as result's rightmost bit
            n = n >> 1;         // Shift n to the right by 1 position
        }
        
        return res;
    }
}
