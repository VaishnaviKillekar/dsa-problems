// Link to problem - https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=study-plan-v2&envId=leetcode-75

/**
 * Intuition - Use sliding window to track maximum ones and k zeroes at any given instant.
 * If number of zeroes exceeds k, then slide the window until it is less than or equal to k.
 * Compute number of ones, max, after updating the left and right pointers of the window.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        int zero = 0;

        while(right < nums.length) {
            if(nums[right] == 1) {
                right++;
                max = Math.max(max, right - left);
            }
            else if(zero < k) {
                zero++;
                right++;
                max = Math.max(max, right - left);
            }
            else {
                max = Math.max(max, right - left);
                // Slide window one position right
                if(nums[left] == 0) {
                    zero--;
                }
                left++;
            }
        }

        return max;
    }
}
