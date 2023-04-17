// Link to problem - https://leetcode.com/problems/find-peak-element/description/

/**
 * Intuition - Use binary search to check if mid is greater than its left and right
 * elements. If it is not, then continue search on the side where the neighbouring
 * element i.e., either left or right was greater.
 *
 * Check if the first and last elements of array satisfy condition before scanning array.
 *
 * Time complexity - O(logn)
 * Space complexity - O(1)
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 1;
        int right = nums.length - 2;
        int mid;

        if(nums.length == 1) {
            return 0;
        }

        if(nums[0] > nums[left]) {
            return 0;
        }
        if(nums[nums.length - 1] > nums[right]) {
            return nums.length - 1;
        }

        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            else if(nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            }
            else if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
        }

        return -1;
    }
}
