// Link to problem - https://leetcode.com/problems/removing-stars-from-a-string/description/

/**
 * Intuition - Iterate the string from the end to beginning and count the stars. When an
 * alphabet is found, if stars count is greater than zero, thenc ontinue to replace all
 * alphabets with stars until count becomes zero.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public String removeStars(String s) {
        char[] str = s.toCharArray();
        int i = s.length() - 1;
        int stars = 0;
        
        while(i >= 0) {
            if(str[i] == '*') {
                while(str[i] == '*') {
                    stars++;
                    i--;
                }
                while(stars > 0 && str[i] != '*') {
                    str[i] = '*';
                    i--;
                    stars--;
                }
            }
            else {
                i--;
            }
        }

        StringBuilder result = new StringBuilder();
        for(int ch = 0; ch < str.length; ch++) {
            if(str[ch] != '*') {
                result.append(str[ch]);
            }
        }

        return result.toString();
    }
}
