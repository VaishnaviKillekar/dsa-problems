// Link to problem - https://leetcode.com/problems/complement-of-base-10-integer/description/

/**
 * Intuition - 
 * To get a number's complement, complement all bits of the given number (~n).
 * Now we need to get rid of the additional 1s that were created on the left side of actual bits.
 * To do that, create a mask which has as many 1s on the right end as actual bits in n.
 * We left shift mask and put 1: mask = (mask << 1) | 1.
 * Finally we can do AND operation between mask and complement of n to get the complement.
 *
 * For ex: n = 10
 * n = 00000000000000000000000000001010
 * m = 00000000000000000000000000001010
 * mask = 00000000000000000000000000000000
 *
 * m = 10: mask = 00000000000000000000000000000001
 * m = 5:  mask = 00000000000000000000000000000011
 * m = 2:  mask = 00000000000000000000000000000111
 * m = 1:  mask = 00000000000000000000000000001111
 * m = 0:  exit
 *
 *   ~n  =      11111111111111111111111111110101
 *    &
 *   mask =     00000000000000000000000000001111
 *            -----------------------------------
 * complement = 00000000000000000000000000000101
 * which is 5
 *
 * Time complexity - O(1)
 * Space complexity - O(1)
 */
class Solution {
    public int bitwiseComplement(int n) {
        int m = n;
        int mask = 0;

        // Edge case - since below loop won't execute and no mask will be created
        if(n == 0) {
            return 1;
        }

        while(m != 0) {
            mask = (mask << 1) | 1;
            m = m >> 1;
        }

        return (~n) & mask;
    }
}
