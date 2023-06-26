// Link to problem - https://leetcode.com/problems/permutations/description/

/**
 * Intuition - Use recursion with backtracking to generate all permutations.
 *
 * Time complexity - O(n * n!) - n! permutations to be generated
 * Space complexity - O(n)
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, result, new ArrayList<>());
        return result;
    }

    public void permute(int[] nums, List<List<Integer>> result, List<Integer> curr) {
        if(curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!curr.contains(nums[i])) {
                curr.add(nums[i]);
                permute(nums, result, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
