// Link to problem - https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/

/**
 * Intuition - 
 * There are 4 cases to consider,
 * Case 1: [1, 2, 3, 4, 5] - Array is sorted and not rotated
 * Case 2: [3, 4, 5, 1, 2] - Array is sorted and rotated
 * Case 3: [1, 4, 2, 9, 0] - Array is not sorted
 * Case 4: [1, 1, 1, 1, 1] - Array contains only duplicates of single number
 *
 * If an array is sorted and rotated, then it should contain only one pair
 * of adjacent elements where previous element is greater than next element.
 * This indicates the position at which the array is rotated.
 * Search the array and increment 'count' when previous > current.
 *
 * We also make a comparison between the first and last element where if
 * last > first, then we increment count. This indicates array is rotated by
 * 0 positions - case 1.
 * Otherwise, it indicates array is rotated by non-zero positions - case 2.
 *
 * In case of arrays containing unsorted elements, 'count' would be greater
 * than 1, indicating array is rotated at more than one place which is not
 * possible - case 3.
 *
 * If array contains duplicates of same element, then 'count' would be 0 - case 4.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public boolean check(int[] nums) {
        int count = 0;

        if(nums[nums.length - 1] > nums[0]) {
            count++;
        }

        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] > nums[i]) {
                count++;
            }
        }

        return count <= 1;
    }
}
