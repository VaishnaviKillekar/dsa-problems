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

/**
 * Intuition - Iterative solution with O(n) space
 * Store the last k elements of array 'nums' into a separate array 'end'.
 * Now rotate 'nums' such that 'i'th position is directly shifted to the
 * right by 'k' positions. When we reach the left of array and do not
 * have elements to shift right, then use elements from 'end'.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        if(k != 0) {
            // Copy the last k elements that move to the start of array
            int end[] = new int[k];
            int j = 0;
            for(int i = nums.length - k; i < nums.length; i++) {
                end[j++] = nums[i];
            }

            // Now rotate all elements
            int m = end.length - 1;
            for(int i = nums.length - 1; i >= 0; i--) {
                nums[i] = i - k >= 0 ? nums[i - k] : end[m--];
            }
        }
    }
}
