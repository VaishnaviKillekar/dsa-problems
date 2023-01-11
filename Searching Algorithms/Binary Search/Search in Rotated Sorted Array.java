// Link to problem - https://leetcode.com/problems/search-in-rotated-sorted-array/description/

/**
 * Intuition - First find pivot using a variation of binary search where mid must be smaller than
 * both left and right.
 * The pivot indicates the number of positions by which the array is rotated.
 * 
 * Now run a binary search to find the target. Use this pivot to find the actual mid and compare
 * that to the target.
 *
 * Time complexity - O(logn)
 * Space complexity - O(1)
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int pivot;

        // Find the pivot
        while(left < right) {
            mid = (left + right) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        pivot = left;    // left = right and it is equal to number of elements rotated

        // Find the element w.r.t pivot
        left = 0;
        right = nums.length - 1;
        while(left <= right) {
            mid = (left + right) / 2;
            int realMid = (mid + pivot) % nums.length;
            if(nums[realMid] == target) {
                return realMid;
            }
            else if(nums[realMid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
