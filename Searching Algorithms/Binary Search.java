// Link to problem - https://leetcode.com/problems/binary-search/

/**
 * Intuition - Recursive approach
 * Start with entire array and check if target is at mid. If yes, return mid.
 * Else reduce the search space by half and search the left or right side of
 * array based on whether target is smaller or larger than mid.
 *
 * Time complexity - O(logn)
 * Space complexity - O(logn)
 */
public class Solution {
    public static int search(int []nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public static int binarySearch(int[] nums, int target, int left, int right) {
        if(left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        if(nums[mid] == target) {
            return mid;
        }
        else if(nums[mid] > target) {
            right = mid - 1;
        }
        else {
            left = mid + 1;
        }
        return binarySearch(nums, target, left, right);
    }
}

/**
 * Intuition - Iterative approach
 * Search the target by constantly reducing search window in half.
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
