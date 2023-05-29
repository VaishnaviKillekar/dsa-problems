// Link to problem - https://leetcode.com/problems/sqrtx/description/

/**
 * Intuition - Use Binary Search to find the squares of numbers between 0 to given number, x.
 * If the square of 'mid' is an exact match of x, then return 'mid' as the square root. If
 * square is less than 'x', then 'mid' could be the square root so store it and search to the
 * right of 'mid' as a number to the right could be an exact match. Otherwise, search to the
 * left of 'mid' as the number needs to be smaller.
 * Use long data type for 'left', 'right' and 'mid' as square of 'mid' could result in overflow.
 *
 * Time complexity - O(logn)
 * Space complexity - O(1)
 */
class Solution {
    public int mySqrt(int x) {
        long sqrt = 0;
        long left = 0;
        long right = x;

        while(left <= right) {
            long mid = left + (right - left) / 2;
            if(mid * mid == x) {
                return Math.toIntExact(mid);
            }
            else if(mid * mid > x) {
                right = mid - 1;
            }
            else {
                sqrt = mid;
                left = mid + 1;
            }
        }

        return Math.toIntExact(sqrt);
    }
}
