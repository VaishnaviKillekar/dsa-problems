// Link to problem - https://leetcode.com/problems/combination-sum-iii/description/

/**
 * Intuition - Every number between 1 to 9 can either be included or excluded to create sum n. Using backtracking to find all
 * possibile combinations. To avoid unnecessary recursive calls, check if the current sum added with current number won't
 * exceed required sum n.
 *
 * Time complexity - O(2^9 * k) - each number betwwen 1-9 can be taken or left so 2 possibilities. k is for copying temp to result
 * Space complexity - O(k) - recurse only till k numbers in combo
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combos = new ArrayList<>();
        getCombos(k, n, combos, new ArrayList<>(), 0, 1);
        return combos;
    }

    public void getCombos(int k, int n, List<List<Integer>> combos, List<Integer> curr, int sum, int num) {
        if(curr.size() == k && sum == n)
        {
            combos.add(new ArrayList<>(curr));
            return;
        }

        for(int i = num; i <= 9; i++) {
            if(sum + i <= n) {
                sum += i;
                curr.add(i);
                getCombos(k, n, combos, curr, sum, i + 1);
                sum -= i;
                curr.remove(curr.size() - 1);
            }
            else {
                break;
            }
        }
    }
}
