// Link to problem - https://leetcode.com/problems/isomorphic-strings/

/**
 * Intuition - Store the mapping from s->t and t->s in two maps. While reading the string s, check if the
 * character is read for the first time in s->t. If yes, verify if character at t contains a mapping in
 * t->s. If there's a mismatch, then return false. If both conditions are false, then add the character 
 * mapping in both maps.
 * Return true, only after loop terminates.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sm = new HashMap<>();
        Map<Character, Character> tm = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            Character currS = s.charAt(i);
            Character currT = t.charAt(i);
            
            // Character from s exists
            if(sm.get(currS) != null) {
                // Verify that existing character from s should map to same character of t
                if(sm.get(currS) != currT) {
                    return false;
                }
                // Also verify that mapping from t to s is unique
                else if(tm.get(currT) != null && tm.get(currT) != currS) {
                    return false;
                }
            }
            // Character from t exists
            else if(tm.get(currT) != null) {
                if(tm.get(currT) != currS) {
                    return false;
                }
                else if(sm.get(currS) != null && sm.get(currS) != currT) {
                    return false;
                }
            }
            else {
                sm.put(currS, currT);
                tm.put(currT, currS);
            }
        }
        return true;
    }
}
