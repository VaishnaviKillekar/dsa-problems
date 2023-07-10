// Link to problem - https://leetcode.com/problems/permutations-ii/description/

/**
 * Intuition - Recursion with Backtracking
 * Sort the given array and maintain a boolean array `used` to track the elements
 * that have been already added to the `tempList`.
 * Use a for loop to go through all possible permutations and add an element to
 * `tempList` only if it is unused and mark it as used.
 *
 * Time complexity - O(n * n!)
 * Space complexity - O(n)
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used) {
        if(tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true; 
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, used);
            used[i] = false; 
            tempList.remove(tempList.size() - 1);
        }
    }
}
