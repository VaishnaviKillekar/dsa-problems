// Link to problem - https://leetcode.com/problems/string-to-integer-atoi/

/**
 * BAD PROBLEM - NO NEED TO SPEND TIME
 *
 * Intuition - Go through solution and study overflow condition.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 *
 * Test cases:
     ""
    "004.2"
    "0.02"
    "42"
    "001"
    "0032"
    "2147483647"
    "-42"
    "-001"
    "-0032"
    "-2147483647"
    "      -2147483647"
    "-002147483647"
    "-2147483647   "
    "-2147483647as"
    "words and 987"
    "    0009a1"
    "    -0009a1"
    "           +0000000a"
    "           -00000001a"
    "         -02147483646"
    "-91283472332"
    "2147483648"
 *
 */
class Solution {
    public int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;

        // Remove leading whitespaces
        while(index < str.length() && str.charAt(index) == ' ')
            index++;

        // Handle sign
        if(index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        // Parse to number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9)
                break;

            // Check if total overflows after 10 times
            if(Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Add digit if no overflow
            total = 10 * total + digit;
            index++;
        }
        
        return total * sign;
    }
}
