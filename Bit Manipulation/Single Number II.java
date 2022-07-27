// Link to problem - https://leetcode.com/problems/single-number-ii/

/**
 * Intuition - Use XOR and two variables - 'ones' and 'twos' to track the number of appearances of a number.
 * 'ones' - contains numbers that appeared only once so far.
 * 'twos' - contains numbers that appeared twice so far.
 *
 * Any number that appears a first time will be in set "ones" and it wwon't be added to "twos". 
 * Any number appearing a second time would have been removed from set "ones" in the previous step and will now be added to set "twos". 
 * Any number appearing a third time will simply be removed from the set "twos" and will no longer exist in either set.
 * Finally, once we are done iterating over the entire list, set "twos" would be empty and set "ones" will contain the only number that appears once.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
}
