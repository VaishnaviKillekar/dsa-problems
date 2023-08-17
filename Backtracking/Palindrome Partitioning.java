// Link to problem - https://leetcode.com/problems/palindrome-partitioning/description/

/**
 * Intuition - Recursively iterate over the string in a DFS fashion.
 * For every recursive call, explore all possible substrings starting at 'start' until 'end' reaches end of string.
 * For every substring, check if it is a palindrome. If yes, recurse by moving start to next index and adding current
 * substring to 'curr' list. 
 * If not a palindrome, increment 'end' and continue checking.
 * On backtracking, remove the last added palindrome and iteration continues to find longer substrings.
 *
 * Time complexity - O(n * 2^n) - checking if string is a palindrome takes O(n) time & backtracking explores 2^n possibile substrings
 * Space complexity - O(n) - depth of recursion tree
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(s, result, new ArrayList<>(), 0);
        return result;
    }

    public void dfs(String s, List<List<String>> result, List<String> curr, int start) {
        if(start >= s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int end = start; end < s.length(); end++) {
            if(isPalindrome(s, start, end)) {
                curr.add(s.substring(start, end + 1));
                dfs(s, result, curr, end + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}



/**
 * Intuition - Recursively iterate over the string in a DFS fashion using memoization.
 * For every recursive call, explore all possible substrings starting at 'start' until 'end' reaches end of string.
 * For every substring, check if it is a palindrome. If substring length <= 2 and start and end character match, 
 * then it is a plaindrome. If length > 2, then consider acca. Here, we check if the string between start and end
 * is a palindrome from dp array as dp[start + 1][end - 1].
 * If yes, recurse by moving start to next index and adding current substring to 'curr' list.
 * If not, increment 'end' and continue checking.
 *
 * On backtracking, remove the last added palindrome and iteration continues to find longer substrings.
 *
 * Time complexity - O(n * 2^n) - n is length of string & backtracking explores 2^n possibile substrings
 * Space complexity - O(n * n) - depth of recursion tree + 2D dp array
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];

        dfs(s, result, dp, new ArrayList<>(), 0);
        return result;
    }

    public void dfs(String s, List<List<String>> result, boolean[][] dp, List<String> curr, int start) {
        if(start >= s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int end = start; end < s.length(); end++) {
            if(s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                curr.add(s.substring(start, end + 1));
                dfs(s, result, dp, curr, end + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
}



/**
 * Intuition - Scan the given string by fixing left part of it. Start with first fixing only
 * first character, then backtrack on the rest of the string. While exploring possibilities,
 * add the fixed parts of the string until the string becomes empty. Now all possibilities 
 * are added to result. Now backtrack by removing the last added palindrome and fixing an
 * extra position in the front.
 *
 * Time complexity - O(n * 2^n) - checking if string is a palindrome takes O(n) time & backtracking explores 2^n possibilities (choose or leave - 2 choices)
 * Space complexity - O(n)
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, result, new ArrayList<>());
        return result;
    }

    public void backtrack(String s, List<List<String>> result, List<String> curr) {
        if(s == null || s.length() == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if(!palindrome(temp)) {
                // Don't explore possibilities if temp is not a palindrome
                continue;
            }
            curr.add(temp);
            backtrack(s.substring(i, s.length()), result, curr);
            curr.remove(curr.size() - 1);
        }
    }

    public boolean palindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
