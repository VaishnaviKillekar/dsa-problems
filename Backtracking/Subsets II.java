// Link to problem - https://leetcode.com/problems/subsets-ii/description/

/**
 * Intuition - Sort the given array and skip over duplicate elements to avoid duplicate 
 * subsets. Use recursion to generate all possible subsets.
 *
 * Time complexity - O(n * 2^n)
 * Space complexity - O(n) - maximum depth of recursion tree when all elements are unique 
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();

        // Sort the given array so duplicate subsets can be avoided
        Arrays.sort(nums);

        getSubsets(nums, powerSet, new ArrayList<>(), 0);
        return powerSet;
    }

    public void getSubsets(int[] nums, List<List<Integer>> powerSet, List<Integer> curr, int index) {
        powerSet.add(new ArrayList<>(curr));

        int i = index;
        while(i < nums.length) {
            curr.add(nums[i]);
            getSubsets(nums, powerSet, curr, i + 1);
            curr.remove(curr.size() - 1);
            i++;

            // Avoid duplicate subsets by skipping over same elements
            while(i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }
    }
}
