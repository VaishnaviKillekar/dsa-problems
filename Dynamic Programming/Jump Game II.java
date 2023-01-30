// Link to problem - https://leetcode.com/problems/jump-game-ii/description/

/**
 * Intuition - Greedy BFS
 * Find the least number of jumps required to reach current level from the
 * preceeding steps and then move on to the next level.
 *
 * The maximum position that can be reached from current level is taken to the
 * next level.
 *
 * Each position 'i' is considered as a level in BFS. We explore all positions
 * that can be reached from the preceeding positions (0 -> i - 1).
 * The maximum reachable position from current level is updated once 'lastJump'
 * position equals current level 'i'. Only then 'jumps' is incremented to ensure
 * minimum value.
 *
 * Current level's maximum reachable position becomes the next level's 'lastJump'
 * position.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int jump(int[] nums) {
        int i = 0;
        int lastJump = 0;
        int maxReachable = 0;
        int jumps = 0;

        while(lastJump < nums.length - 1) {
            // Farthest index reachable from current step i
            maxReachable = Math.max(maxReachable, i + nums[i]);
            // Current level has been fully explored and the next level's max jump finalised
            if(i == lastJump) {
                lastJump = maxReachable;
                jumps++;    // Update when current level is fully explored to get min
            }
            i++;
        }

        return jumps;
    }
}

/**
 * Intuition - DP
 * Find the least number of steps required to reach every step from its
 * preceeding steps.
 *
 * The 0th step can be reached in 0 ways. 
 * 1st step can be reached from 0th step in 1 way.
 * 2nd step can be reached from 0th and 1st step -> 2 ways
 *
 * Maintain the minimum jumps required to reach a step in an array `min`.
 * For every step i, find all the steps that can be used to reach i and then store
 * the minimum in `min` for i.
 *
 * Time complexity - O(n^2)
 * Space complexity - O(n)
 */
class Solution {
    public int jump(int[] nums) {
        int[] min = new int[nums.length];

        for(int i = 1; i < nums.length; i++) {
            int curr = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++) {
                // Check if current step can be used to reach i
                if(j + nums[j] >= i) {
                    curr = Math.min(curr, min[j]);
                    min[i] = curr + 1;
                }
            }
        }

        return min[nums.length - 1];
    }
}
