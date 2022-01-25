// Link to problem - https://leetcode.com/problems/delete-and-earn/

/**
 * Intuition - First sort the array and then maintain a map of the sum of all occurrences of each number.
 * Use this map to later jump indices while choosing the numbers to determine maximum sum.
 * For every nums[i], check if nums[i]-1 == nums[i] --> consecutive. In this case, only one number can be chosen.
 * The sum of occurrences of the number which is the highest is included.
 *
 * Recurrence relation: dp[i] = Max{dp[i-1], sum + dp[i-2]} - if numbers are consecutive.
 *                      dp[i] = dp[i-1] + sum - if numbers are not consecutive.
 * Base cases:
 *            dp[0] = 0
 *            dp[1] = sum of all occurrences of lowest number - nums[0]
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int dp[] = new int[nums.length + 1];
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++) {
            if(numMap.get(nums[i]) == null) {
                numMap.put(nums[i], nums[i]);
            } else {
                numMap.put(nums[i], numMap.get(nums[i]) + nums[i]);
            }
        }
        
        dp[0] = 0;
        dp[1] = numMap.get(nums[0]);
        int i = dp[1] / nums[0];
        int j = 2;
        
        while(i < nums.length) {
            if(nums[i] - 1 == nums[i-1]) {
                dp[j] = Math.max(dp[j-1], dp[j-2] + numMap.get(nums[i]));
            } 
            else {
                dp[j] = dp[j-1] + numMap.get(nums[i]);
            }
            i += (numMap.get(nums[i]) / nums[i]);
            j++;
        }
        
        return dp[j - 1];
    }
}
