// Link to problem - https://leetcode.com/problems/permutations/description/

/**
 * Intuition - Recursion with backtracking to generate all permutations.
 * Start with tracking current element under consideration using 'index'.
 * Swap the current element i with element at 'index' and recurse. Swapping
 * elements will generate all permutations.
 * When 'index' goes beyond array, then add current array as a permutation.
 * On backtracking, undo the swap.
 *
 * Time complexity - O(n!) - n! permutations to be generated
 * Space complexity - O(n)
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> perms = new LinkedList<>();
        int index = 0;

        permute(nums, perms, index);
        return perms;
    }

    public void permute(int[] nums, LinkedList<List<Integer>> perms, int index) {
        if(index >= nums.length) {
            // Add current permutation to result
            perms.add(Arrays.stream(nums).boxed().toList());
            return;
        }

        for(int i = index; i < nums.length; i++) {
            swap(nums, i, index);               // Swap current and index
            permute(nums, perms, index + 1);    // Find the next set of permutations
            swap(nums, i, index);               // Undo swap
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

/**
 * Intuition - Recursion with backtracking to generate all permutations.
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
