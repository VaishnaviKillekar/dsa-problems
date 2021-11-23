// Link to problem - https://leetcode.com/problems/longest-palindromic-substring/solution/

/**
 * Intuition - Every substring can be expapnded around its center to verify if it is a palindrome.
 * Consider "aba". The substring is a palindrome with 'b' at its center. So it needs to be expanded using expand(S, i, i).
 * Consider "aa". The substring is a palindrome with its center between the two 'a's. So it needs to be expanded using expand(S, i, i+1).
 * One of these functions yeilds the longest palindrome and that is compared with the current maximum length. If it is greater than max,
 * then reset the 'start' and 'end' to point to the beginning and ending of the new found maximum palindrome.
 *
 * Time complexity - O(n^2)
 * Space complexity - O(1)
 *
 */

class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int max = Math.max(len1, len2);
            
            if(max > end - start) {
                start = i - (max - 1) / 2;
                end = i + (max / 2);
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    public int expand(String s, int i, int j) {
        while(i > -1 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}