// Link to problem - https://leetcode.com/problems/subsets/

/** 
 * Intuition - Start with an empty array and use recursion to generate all subsets
 *             [ ]
 *       [1]   [2]    [3]
 *    [1,2]   [2,3]   [3,4]
 *   [1,2,3]
 * 
 * Time complexity - O(n)
 * Space complexity - O(logn)
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        sets.add(new ArrayList());
        powerSet(nums, sets, 0, sets.get(0));
        return sets;
    }
    
    public void powerSet(int[] nums, List<List<Integer>> sets, int pos, List<Integer> prev) {
        while(pos < nums.length) {
            List<Integer> curr = new ArrayList(prev);
            curr.add(nums[pos]);
            sets.add(curr);
            powerSet(nums, sets, pos+1, curr);
            pos++;
        }
    }
}
