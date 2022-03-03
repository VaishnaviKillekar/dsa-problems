// Link to problem - https://leetcode.com/problems/is-subsequence/

/*
 * Intuition - Scan the string t and match every character with 'pointer' pointing string s.
 * When there's a match advance 'pointer' of s. Check if 'pointer' reached length of s in each iteration.
 * At the end of loop, if 'pointer' value is length of s, then the subsequence is present, otherwise, it's not.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 *
 * TODO - Design solution for follow-up question of this problem.
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int pointer = 0;
        
        for(int i = 0; i < t.length(); i++) {
            if(pointer == s.length()) {
                return true;
            }
            if(t.charAt(i) == s.charAt(pointer)) {
                pointer++;
            }
        }
        if(pointer == s.length()) {
                return true;
        }
        return false;
    }
} 
