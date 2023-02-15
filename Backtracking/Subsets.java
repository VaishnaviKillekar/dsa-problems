// Link to problem - https://leetcode.com/problems/subsets/

/**
 * Intuition - Backtracking [ Concise solution ]
 * Use index to track the current element to be added. Since subsets are unique, only add elements
 * to 'curr' whose index is higher than current index to avoid permutations of already added subsets.
 *
 * Time complexity - O(2^n) - since total count of all subsets is 2^n 
 * Space complexity - O(n) - recursion tree at the max will have n levels. 'curr' at the max will hold all n elements.
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generateSubsets(nums, res, new ArrayList<>(), 0);
        return res;
    }

    public void generateSubsets(int[] nums, List<List<Integer>> res, List<Integer> curr, int index) {
        res.add(new ArrayList<>(curr));

        for(int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            generateSubsets(nums, res, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}


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
