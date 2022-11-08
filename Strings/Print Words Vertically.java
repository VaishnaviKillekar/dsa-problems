// Link to problem - https://leetcode.com/problems/print-words-vertically/description/

/**
 * Posted solution - https://leetcode.com/problems/print-words-vertically/solutions/2791213/java-easy-1ms-97-efficient-solution/
 *
    # Intuition
    Split the given string into an array of strings so they can be easily accessed. 
    Instead of taking one character at specific index from each string, use all characters of 
    current string and place them in their positions in result.

    # Approach
    Split the given string into an array of strings `strs` and find the longest string length `maxLen` 
    to ensure proper spaces are added in the resulting strings.
    Start scanning the array of strings `strs` and for each string, place all its characters at the 
    `i`th position from `0` to `maxLen` in the result `res`.

    Finally, remove the trailing spaces of all strings in the end.

    For e.g., 
    [HOW, ARE, YOUR]
    maxLen = 4

    HOW: `res -> [H, O, W, ' ']`
    ARE: `res -> [HA, OR, WE, '  ']`
    YOUR: `res -> [HAY, ORO, WEU, '  R']`

    # Time complexity - O(n^2) [when max length of a string is equal to number of strings]

    # Space complexity - O(n)
   *
   *
*/
class Solution {
    public List<String> printVertically(String s) {
        List<String> res = new ArrayList<>();
        String[] strs = s.split(" ");
        int maxLen = 0;

        // Find the longest string
        for(int i = 0; i < strs.length; i++) {
            maxLen = Math.max(maxLen, strs[i].length());
        }

        // Print words
        for(int i = 0; i < strs.length; i++) {
            for(int j = 0; j < maxLen; j++) {
                String curr = res.size() > j ? res.get(j) : null;
                String suffix = (j <= (strs[i].length() - 1) ? String.valueOf(strs[i].charAt(j)) : " ");
                if(curr == null) {
                    curr = suffix;
                }
                else {
                    curr += suffix;
                }
                if(res.size() > j) {
                    res.set(j, curr);
                }
                else {
                    res.add(curr);
                }
            }
        }

        // Remove trailing spaces
        for(int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i).stripTrailing());
        }

        return res;
    }
}
