// Link to problem - https://leetcode.com/problems/combinations/description/

/**
 * Intuition - Backtracking
 *
 * Time complexity - O()
 * Space complexity - O()
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combos = new ArrayList<>();

        getCombos(n, k, combos, new ArrayList<>(), 1);

        return combos;
    }

    public void getCombos(int n, int k, List<List<Integer>> combos, List<Integer> curr, int num) {
        if(curr.size() == k) {
            combos.add(new ArrayList<>(curr));
            return;
        }

        for(int i = num; i <= n; i++) {
            curr.add(i);
            getCombos(n, k, combos, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
