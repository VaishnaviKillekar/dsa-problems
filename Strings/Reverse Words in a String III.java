// Link to problem - https://leetcode.com/problems/reverse-words-in-a-string-iii/

/**
 * Intuition - Split the string into an array of strings using whitespace as a delimiter.
 * Iterate through each string in the array and scan the strings from the end to start.
 * Append the characters read in reverse into the result string.
 * 
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] split = s.split(" ");

        for(int i = 0; i < split.length; i++) {
            String curr = split[i];
            int pt = curr.length() - 1;
            while(pt >= 0) {
                res.append(curr.charAt(pt--));
            }
            res.append(" ");
        }

        return res.substring(0, res.length() - 1).toString();
    }
}
