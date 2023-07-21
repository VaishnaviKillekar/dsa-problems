// Link to problem - https://leetcode.com/problems/combination-sum-ii/description/

/**
 * Intuition - Use backtracking along with a 'used' boolean array to avoid duplicate combinations.
 * Sort the given array so 'used' can effectively track if duplicates have been used. A duplicate
 * element can be used only if the first occurrence is used i.e., if we [2,2] and target is 4, then
 * both 2s can be used to create a combination. Hence used[0] = true and only then second 2 can be
 * considered. If the first 2 is not used, then this is likely a different recursion which will
 * avoid a duplicate combo.
 * We make recursive call only if sum is lower than or equal to target to avoid TLE.
 *
 * Time complexity - 
 * Space complexity - O(n)
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];

        // Sort array to avoid duplicate combinations
        Arrays.sort(candidates);

        getCombos(candidates, target, result, used, new ArrayList<>(), 0, 0);

        return result;
    }

    public void getCombos(int[] candidates, int target, List<List<Integer>> result, boolean[] used, List<Integer> curr, int sum, int index) {
        if(sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            // If duplicate is found, then include only if previous occurrence is chosen
            if(i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            // Add current to combo
            used[i] = true;
            curr.add(candidates[i]);

            // Generate combinations using curr - if condition prevents TLE due to unnecessary recursive calls
            if(sum + candidates[i] <= target)
                getCombos(candidates, target, result, used, curr, sum + candidates[i], i + 1);

            // Remove current for next combination
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}
