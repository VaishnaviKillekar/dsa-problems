// Link to problem - https://leetcode.com/problems/remove-duplicates-from-sorted-array/

/**
 * Intuition - Use two-pointer technique where i points to the first instance of a number
 * and j is incremented until the next unique number is found. It passes through duplicates.
 * Replace the i+1 position with unique j and continue.
 *
 * Time coplexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        
        while(j < nums.length) {
            while(j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            if(j < nums.length) {
                nums[i + 1] = nums[j];
            }
            else {
                break;
            }
            i++;
            j++;
        }
        
        return i + 1;
    }
}
