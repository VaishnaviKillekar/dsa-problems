// Link to problem - https://leetcode.com/problems/hamming-distance/

/**
 * Intuition - Shift the numbers 'x' and 'y' to the right and get the last bit.
 * Compare their bits and increment distance if they are unequal.
 *
 * Time complexity - O(1)
 * Space complexity - O(1)
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int dist = 0;
        
        while(x != 0 || y != 0) {
            if((x & 1) != (y & 1)) {
                dist++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        
        return dist;
    }
}
