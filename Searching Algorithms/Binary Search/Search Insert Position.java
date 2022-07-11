// Link to problem - https://leetcode.com/problems/search-insert-position/

/**
 * Intuition - Use Binary Search to scan through the array. If the target is not found,
 * then return mid. 'mid' will be either in the array or will be an index outside the
 * array.
 *
 * Time complexity - O(logn)
 * Space complexity - O(1)
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        
        while(left <= right) {
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        
        return mid;
    }
}
