// Link to problem - https://leetcode.com/problems/number-of-1-bits/


/**
 * Intuition - Get the rightmost bit in the input and increment count if it is 1.
 * Since Java does not support unsigned integers, we need to treat the input as
 * unsigned. After reading the rightmost bit, shift the input to the right by 1.
 *
 * In Java, unisgned right shift is done using >>>. Signed shift is done using >>.
 * As the number is signed and problem requires it to be treated as unsigned use
 * unsigned shift operator >>>.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        
        while(n != 0) {
            if((n & 1) == 1) {
                count++;                
            }
            n = n >>> 1;
        }
        return count;
    }
}
