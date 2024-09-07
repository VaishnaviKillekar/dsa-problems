// Link to problem - https://leetcode.com/problems/determine-if-two-strings-are-close

/**
 * Intuition - We can easily check that if two words are close, then they must contain the same set of characters 
 * and the occurrences of characters must also be the same.
 * For e.g., word1 = "aab" and word2 = "bba"
 * Condition 1: Both words contain characters a and b.
 * 
 * Condition 2:
 * In word1, the word frequencies are a -> 2 and b -> 1 => [2,1]
 * In word2, the word frequencies are a -> 1 and b -> 2 => [1,2]
 * The frequencies contain the same counts.
 * 
 * Strings which satisfy these conditions are close and we do not need to manually swap and verify the characters.
 * 
 * Store the frequencies of characters in both words in two arrays. Now iterate through both arrays and store the 
 * unique count as key and number of characters with the same as value in two separate maps for two words. 
 * While iterating through second array, check if the character is present in first word. If not, then the two 
 * words are not close.
 * Finally iterate through the first map and compare the key and value are a match in the second map.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Count the occurrences of each character in both words
        for(int i = 0; i < word1.length(); i++) {
            count1[word1.charAt(i) - 'a']++;
        }

        for(int i = 0; i < word2.length(); i++) {
            count2[word2.charAt(i) - 'a']++;
        }

        // Store the count -> number of characters with same count in two maps
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for(int i = 0; i < 26; i++) {
            if(count1[i] != 0) {
                if(count2[i] == 0) {
                    // If this character does not exist in other string - strings are not close
                    return false;
                }
                map1.put(count1[i], map1.getOrDefault(count1[i], 0) + 1);
            }
        }
        for(int i = 0; i < 26; i++) {
            if(count2[i] != 0) {
                map2.put(count2[i], map2.getOrDefault(count2[i], 0) + 1);
            }
        }

        // Both the words should have the same number of characters with the same count
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int count = entry.getKey();
            int chars = entry.getValue();
            if(map2.getOrDefault(count, 0) != chars) {
                return false;
            }
        }

        return true;
    }
}
