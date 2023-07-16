// Link to problem - https://leetcode.com/problems/combination-sum/description/

/**
 * Intuition - Sort the given array so elements can be added in right order to increase
 * sum until its equal to target.
 * use standard backtracking approach, where add current element and recurse until sum
 * is less than target. On backtracking, remove added element and move to next element.
 *
 * Time complexity - ?
 * Space complexity - O(target)
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        getCombos(candidates, target, result, new ArrayList<>(), 0, 0);

        return result;
    }

    public void getCombos(int[] candidates, int target, List<List<Integer>> result, List<Integer> curr, int sum, int index) {
        // Current combination sum is equal to target, then add combination to result
        if (sum == target) {
            result.add(new ArrayList<>(curr));
        } 
        else if (sum < target) {
            for (int i = index; i < candidates.length; i++) {
                // Add current candidate to the combination
                curr.add(candidates[i]);
                // Recursively call with the updated sum and index
                getCombos(candidates, target, result, curr, sum + candidates[i], i);
                // Remove the last candidate from the combination before exploring the next one
                curr.remove(curr.size() - 1);
            }
        }
    }
}
