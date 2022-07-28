// Link to problem - https://leetcode.com/problems/valid-anagram/

/**
 * Intuition - Add the elements from s along with their number of occurrences in a HashMap.
 * Now iterate through t and reduce the count of elements from HashMap based on current t.
 * If current character from t does not exist in HashMap, then t is not an Anagram.
 * Else, reduce the count for that entry and continue.
 *
 * Initial check - Both strings must be of the same size to be anagrams.
 *
 * Alternate approach - 
 * Create an array of size 26 to store the number of occurrences of each alphabet from s.
 * While iterating through t, reduce the count in that alphabet's index.
 * Now go through the count array and check if any index is non-zero.
 * If yes - strings are not anagrams.
 *
 * Issues - 
 * 1. Requires an additional round og iteration of fixed size array.
 * 2. Works when the input domain is known. If character domain increases or is unknown - unfeasible
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        if(s.length() != t.length()) {
            return false;
        }
        
        // Get number of occurrences of all characters in s
        for(int i = 0; i < s.length(); i++) {
            Integer count = map.get(s.charAt(i));
            if(count != null) {
                count++;
            }
            else {
                count = 1;
            }
            map.put(s.charAt(i), count);
        }
        
        // Match the characters in s with t
        for(int j = 0; j < t.length(); j++) {
            Integer count = map.get(t.charAt(j));
            if(count != null) {
                count--;
                if(count <= 0) {
                    map.remove(t.charAt(j));
                }
                else {
                    map.put(t.charAt(j), count);
                }
            }
            else {
                return false;
            }
        }
        
        return map.size() == 0 ? true : false;
    }
}
