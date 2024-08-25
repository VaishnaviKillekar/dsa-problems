// Link to problem - https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75

/**
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    public int gcd(int x, int y) {
        if(y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}


class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(str2.length() > str1.length()){
            return gcdOfStrings(str2, str1);
        }

        if(str2.equals(str1)){
            return str2;
        }

        if(str1.startsWith(str2)){
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }

        return "";
    }
}
