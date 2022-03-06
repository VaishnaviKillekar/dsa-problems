// Link to problem - https://leetcode.com/problems/arithmetic-slices/

/*
 * Intuition - Dynamic programming approach - 
 * Maintain the position 'pos' of the first element of the slice being considered. The 'count' is incremented
 * when the current element's difference with its previous matches the current difference 'diff'.
 * If 'count' exceeds 3, then the add the number of slices for previous number dp[i-1] and the number of slices
 * that can be formed with current element into the slice - (slice - 2).
 *
 * If the difference of current element with its previous does not match with current difference, then reset the
 * count to 2 and set the position 'pos' to the previous element as that will now form the new start of slice with
 * the new difference 'diff'.
 *
 * Time complexity - O(n)
 * Space complexity - O(n) - replace dp[] with prev and curr variables, then it becomes O(1).
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        int dp[] = new int[nums.length];

        if(nums.length < 3) {
            return 0;
        }

        int count = 2;
        int pos = 0;
        int diff = nums[1] - nums[0];
        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2; i < nums.length; i++) {
            if(nums[i] - nums[i-1] == diff) {
                count++;
                if(count >= 3) {
                    int slice = i - pos + 1;
                    dp[i] = dp[i-1] + (slice - 2);
                }
            }
            else {
                diff = nums[i] - nums[i-1];
                pos = i - 1;
                count = 2;
                dp[i] = dp[i-1];
            }
        }
        return dp[nums.length-1];
    }
}


/*
 * Intuition - Algorithmic approach without DP - 
 * Compare difference between 3 elements at a time - i, i-1 and i-2. If the difference matches between pairs,
 * then increment 'slice' by 1 and add it to the count.
 * In this way, if we have [1,2,3,4], then the 'slice' value will increment as 1,2 and will be added to the
 * total in this incrementing pattern.
 * 
 * The pattern that slice increments in is as below -
 * [1,2,3]     - 1       -> 1
 * [1,2,3,4]   - 1, 2    -> 3
 * [1,2,3,4,5] - 1, 2, 3 -> 6
 *
 * When there is a difference mismatch, then 'slice' is reset to 0 indicating a new slice is being considered.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int slice = 0;

        for(int i = 2; i < nums.length; i++) {
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                slice++;
                count += slice;
            }
            else {
                slice = 0;
            }
        }

        return count;
    }
}
