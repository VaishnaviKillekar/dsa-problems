// Link to new problem - https://leetcode.com/problems/search-insert-position/

/**
 * Intuition - Run a binary search until left < right pointer. When they are equal, then the mid = left = right.
 * In this case, the target should either be to the left or to the right of the mid pointer.
 * If the target > mid, then return mid + 1. Else, return mid as the target must be at current mid position.
 *
 * Time complexity - O(logn)
 * Space complexity - O(1)
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;

        while(left < right) {
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                left = mid + 1;
                mid = (left + right) / 2;
            }
            else {
                right = mid - 1;
                mid = (left + right) / 2;
            }
        }
        
        if(target > nums[mid]) {
            return mid + 1;
        }
        return mid;
    }
}
