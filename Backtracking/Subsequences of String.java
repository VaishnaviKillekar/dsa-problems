// Link to problem - https://www.codingninjas.com/codestudio/problems/subsequences-of-string_985087

/**
 * Intuition - Backtracking approach
 * This is similar to Subsets problem where we fetch the last added combination from result and add
 * the next character from left to right.
 * Consider ex: 
 *               abc
 *            /   |   \
 *          a     b     c
 *        /   \   |
 *      ab    ac  bc
 *      |
 *     abc
 *
 * Time complexity - O(2^n)
 * Space complexity - O(n) - recursion tree height will be n when the entire string is added to result
 */
class Solution {
    public static ArrayList<String> subsequences(String str) {
        ArrayList<String> result = new ArrayList<String>();

        for(int i = 0; i < str.length(); i++) {
            // Add the current character
            result.add(String.valueOf(str.charAt(i)));
            // Find all combinations
            getSubsequences(str, result, i);
        }

        return result;
    }

    public static void getSubsequences(String str, ArrayList<String> result, int i) {
        // Get the last added subsequence
        String last = result.get(result.size() - 1);

        for(int j = i + 1; j < str.length(); j++) {
            String next = last + String.valueOf(str.charAt(j));
            result.add(next);
            getSubsequences(str, result, j);
        }
    }
}
