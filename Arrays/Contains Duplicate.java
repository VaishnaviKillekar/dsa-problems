// Link to problem - https://leetcode.com/problems/contains-duplicate/

/**
 * Intuition - Add elements to a set. Since set only allows unique elements,
 * compare the size of the array and set. If there's a mismatch, then array
 * contains duplicates.
 * Solution can be optimized by adding a check to see if element exists in set
 * and return true immediately.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        
        return false;
    }
}
