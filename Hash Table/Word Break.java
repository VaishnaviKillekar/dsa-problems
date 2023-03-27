// Link to problem - https://leetcode.com/problems/word-break/description/

/**
 * Intuition - Check for all possible substrings of given string and verify
 * if they are present in the given word dictionary. For every search done for a
 * substring, store the result in a map to avoid rechecking.
 *
 * Time complexity - O(2^n)
 * Space complexity - O(n)
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>(wordDict);
        Map<String, Boolean> map = new HashMap<>();
        return search(s, dict, map);
    }

    public boolean search(String s, Set<String> dict, Map<String, Boolean> map) {
        if(s.length() == 0) {
            return true;
        }

        for(int i = 1; i <= s.length(); i++) {
            Boolean present = map.get(s.substring(i));
            if(dict.contains(s.substring(0, i)) && (present == null || present == true)) {
                if(search(s.substring(i), dict, map)) {
                    map.put(s.substring(i), true);
                    return true;
                }
                else {
                    map.put(s.substring(i), false);
                }
            }
        }

        return false;
    }
}
