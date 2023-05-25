// Link to problem - https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

/**
 * Intuition - The given array size indicates the range of elements [1, N].
 * Since every element of array is in this range, we can use the elements
 * as indices pointing to other elements. If two elements point to the same
 * index, then that index + 1 is the duplicate.
 * While scanning the array, check for (current element value - 1) as index.
 * -1 since we don't go out of array range. Mark the elements at index as
 * negative to track which have been referenced. In case of duplicate, the
 * element at computed index will already be negative and we can add index + 1 
 * as duplicate in result.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) {
                result.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }

        return result;
    }
}
