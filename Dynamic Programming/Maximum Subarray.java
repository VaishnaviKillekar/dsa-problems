// Link to problem - https://leetcode.com/problems/maximum-subarray/

/**
   Test cases -
    [-2,1,-3,4,-1,2,1,-5,4]
    [5,4,-1,7,8]
    [1]
    [-2,1,-3,-4,-1,2,1,-5,4]
    [-2,1,-3,4,-1,2,1,-5,14]
    [1,2,3,4]
    [0]
    [0,0]
    [0,0,0]
    [0,-1]
    [0,-1,-2]
    [0,-1,2]
    [0,-1,2,-1]
*/

/**
 * Intuition - Kadane's Algorithm
 * Initially both max and sum are set to first element. Start scanning array from 2nd
 * element. Add current element to sum. If this sum is smaller than current element
 * itself, then reset sum to current element.
 * If sum > max, then set new max.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if(sum < nums[i]) {
                sum = nums[i];
            }
            max = sum > max? sum : max;
        }
        
        return max;
    }
}


/**
 * Intuition - Kadane's Algorithm
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
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
