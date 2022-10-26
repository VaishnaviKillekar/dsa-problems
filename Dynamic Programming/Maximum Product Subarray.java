// Link to problem - https://leetcode.com/problems/maximum-product-subarray/

/**
 * Intuition - 
 * Since Product of numbers can turn from minimum to maximum in case of negative numbers, we
 * maintain both minimum and maximum products yet for every element.
 * For every element, multiply it both min and max so far. Minimum and maximum of these will
 * be compared with the element itself. The least value is the new minSoFar and max value is
 * the maxSoFar.
 *
 * Test cases - 
    [2,3,-2,4]
    [-2,0,-1]
    [-2,0,1]
    [2,0,-1]
    [-2,3,-2,4]
    [-2,3,0,-2,4]
    [0,-2,3,-2,4]
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int prevMin = nums[0];
        int prevMax = nums[0];
        int minSoFar;
        int maxSoFar;
        
        for(int i = 1; i < nums.length; i++) {
            minSoFar = Math.min(Math.min(nums[i] * prevMin, nums[i] * prevMax), nums[i]);
            maxSoFar = Math.max(Math.max(nums[i] * prevMin, nums[i] * prevMax), nums[i]);
            max = Math.max(max, maxSoFar);
            prevMin = minSoFar;
            prevMax = maxSoFar;
        }
        
        return max;
    }
}
