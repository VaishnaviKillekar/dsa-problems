// Link to problem - https://leetcode.com/problems/maximum-subarray/


// O(n) solution - Kadane's Algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr = 0;
        
        for(int i = 0; i < nums.length; i++) {
            curr += nums[i];
            if(curr > max) {
                max = curr;
            }
            if(curr < 0) {
                curr = 0;
            }
        }
        return max;
    }
}


/**
 * DP approach with O(n) space complexity
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] sum = new int[nums.length];
        sum[0] = nums[0];

        for(int i = 1; i < sum.length; i++) {
            sum[i] = nums[i] + (sum[i-1] > 0 ? sum[i-1] : 0);
            max = Math.max(sum[i], max);
        }
        return max;
    }
}


/**
 * DP solution with O(1) space complexity
 */
 class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int temp = sum + nums[i];
            if(nums[i] > temp || temp < 0) {
                sum = nums[i];
            }
            else {
                sum = temp;
            }
            if(sum > max) {
                max = sum;
            }
        }
        
        return max;
    }
}
