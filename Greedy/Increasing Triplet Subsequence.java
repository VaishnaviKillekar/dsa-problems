// Link to problem - https://leetcode.com/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75

/**
 * Intuition - Track the first and second elements of the tuple. The lowest number is stored as first.
 * The number higher than 'first', but lower than 'second' is 'second'. Any number higher than both
 * indicates that there is such a tuple.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int num : nums) {
            if(num <= first) {
                first = num;
            }
            else if(num <= second) {
                second = num;
            }
            else {
                return true;
            }
        }

        return false;
    }
}
