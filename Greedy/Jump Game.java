// Link to problem - https://leetcode.com/problems/jump-game/description/


/**
 * Intuition - Greedy approach
 * Scan the array from the back and track the index that can be reached.
 * Initially, the last index is to be reached so `left` is n - 1. Continue going
 * through the array such that if we can jump to `left` using the current index,
 * then update current index as `left`. In this way, we check if we can reach the
 * first index. This indicates there's a path to reach the last index.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int left = n - 1;

        for(int i = n - 2; i >= 0; i--) {
            if(i + nums[i] >= left) {
                left = i;
            }
        }

        return left <= 0;
    }
}
