// Link to problem - https://leetcode.com/problems/rotate-array/

/**
 * Intuition - Reverse parts of array based on k.
 * First reverse the entire array, then reverse first k-1 elements,
 * followed by remaining elements. This rotates the array by k positions.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int left, int right) {
        while(left < right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
    }
}
