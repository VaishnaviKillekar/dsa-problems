// Link to problem - https://leetcode.com/problems/reverse-string/

/**
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        
        while(left < right) {
            char t = s[left];
            s[left] = s[right];
            s[right] = t;
            left++;
            right--;
        }
    }
}
