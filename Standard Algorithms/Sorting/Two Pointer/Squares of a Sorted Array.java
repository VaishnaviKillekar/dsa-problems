// Link to problem - https://leetcode.com/problems/squares-of-a-sorted-array/

/**
 * Intuition - Use two pointers which point to the start and end of given array.
 * Since the array is already sorted, we only need to compare the elements at
 * the start and end of array as elements can be negative and will be larger
 * when squared.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int res[] = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int k = j;
        
        while(i <= j) {
            if(Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[k--] = nums[i] * nums[i];
                i++;
            }
            else {
                res[k--] = nums[j] * nums[j];
                j--;
            }
        }
        
        return res;
    }
}
