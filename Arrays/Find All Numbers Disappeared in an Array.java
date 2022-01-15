// Link to problem - https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

/**
 * Intuition - In the first iteration, the element at index which corresponds to current element is made negative.
 * For e.g. consider [1,3,3]. a[0] = 1, so make the element at index i-1 as 0. Array now becomes [-1,3,3].
 * a[1] = 3, so make i-1 negative => a[2] = -3. Array now becomes [-1,3,-3].
 * a[2] < 0, so do not make changes.
 * We now scan the array once again to only add indices of elements to a new array which are not negative. These are the missing numbers.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
 class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missing = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = 0 - Math.abs(nums[index]);
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                missing.add(i + 1);
            }
        }
        
        return missing;
    }
}
