// Link to problem - https://leetcode.com/problems/permutation-in-string/description/

/**
 * Intuition - Store the character counts of s1 in alphabet array, 's1Count' and
 * then store the character counts of characters in s2 of first window in 's2Count'.
 * Now compare the first window 's2Count' with 's1Count'. If it's not a match, then
 * decrement the count of first character of window in 's2Count' and slide window forward.
 * In subsequent iterations, first increment character count of last newly added character
 * in window and then compare 's1Count' and 's2Count'.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        int windowSize = s1.length();

        if(windowSize > s2.length()) {
            return false;
        }

        // Get count of all characters present in s1
        for(int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
        }

        // Get count of all characters in first window of s2
        for(int j = 0; j < windowSize; j++) {
            s2Count[s2.charAt(j) - 'a']++;
        }

        // Now slide window through s2 and check if character counts in window match s1Count
        int i = 0;
        while(i + windowSize - 1 < s2.length()) {
            if(i != 0) {
                // First window character count is already completed - compare directly
                s2Count[s2.charAt(i + windowSize - 1) - 'a']++;
            }
            // Compare if s2Count matched s1Count
            boolean found = true;
            for(int k = 0; k < 26; k++) {
                if(s1Count[k] != s2Count[k]) { 
                    found = false;
                    break;
                }
            }
            if(found) {
                return found;
            }

            // Slide window - decrement first character in window count
            s2Count[s2.charAt(i) - 'a']--;
            i++;
        }

        return false;
    }
}
