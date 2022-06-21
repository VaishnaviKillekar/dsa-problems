// Link to problem - https://leetcode.com/problems/binary-search/

/**
 * Intuition - Search the targetby constantly reducing search window in half.
 *
 * Time complexity - O(logn)
 * Space complexity - O(1)
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        
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
            mid = (left + right) / 2;
        }
        
        return -1;
    }
}
