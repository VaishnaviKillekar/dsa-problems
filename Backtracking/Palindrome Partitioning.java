// Link to problem - https://leetcode.com/problems/palindrome-partitioning/description/

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
