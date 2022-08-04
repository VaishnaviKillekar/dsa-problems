// Link to problem - https://leetcode.com/problems/valid-palindrome/

/**
 * Intuition - Iterate through the string and compare only alphanumeric characters using 'left' and
 * 'right' pointers.
 * Skip over characters that are not alphanumeric and increment or decrement the pointer based on it.
 * If all match, it's a palindrome.
 *
 * Better solution as space is constant and string is iterated on only once.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right) {
            if((Character.toLowerCase(s.charAt(left)) >= 'a' && Character.toLowerCase(s.charAt(left)) <= 'z') || (Character.toLowerCase(s.charAt(left)) >= '0' && Character.toLowerCase(s.charAt(left)) <= '9')) {
                if((Character.toLowerCase(s.charAt(right)) >= 'a' && Character.toLowerCase(s.charAt(right)) <= 'z') || (s.charAt(right) >= '0' && s.charAt(right) <= '9')) {
                    if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                        return false;
                    }
                    left++;
                    right--;
                }
                else {
                    right--;
                }
            }
            else {
                left++;
            }
        }
        
        return true;
    }
}

/**
 * Intuition - Iterate through the string and store only valid characters in an array. In case of uppercase
 * alphabets, convert them to lower case before storing.
 * Now use two-pointer approach and compare the front and end of the array to match the characters.
 * If all match, it's a palindrome.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public boolean isPalindrome(String s) {
        List<Character> str = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++) {
            if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                str.add(s.charAt(i));
            }
            else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                str.add(Character.toLowerCase(s.charAt(i)));
            }
        }
        
        int left = 0;
        int right = str.size() - 1;
        while(left < right) {
            if(str.get(left++) != str.get(right--)) {
                return false;
            }
        }
        
        return true;
    }
}
