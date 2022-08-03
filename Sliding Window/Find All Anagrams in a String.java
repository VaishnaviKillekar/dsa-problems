// Link to problem - https://leetcode.com/problems/find-all-anagrams-in-a-string/

/**
 * Intuition - Crude approach - do better
 * Use sliding window approach to start scanning from the start of the string 's'. All character
 * occurrences of 'p' are stored in a HashMap 'given'. While scanning s, add all the character read into
 * another HashMap 'curr'. Do this until all characters in the window occur in p. Otherwise, clear 'curr'
 * and restart the process by sliding window to a position after current position.
 * Once the whole window is scanned, compare 'curr' with 'given' for all character occurrences.
 * If it's a match, then store the 'left' of the window. Else, continue until the end of string 's'.
 *
 * Time complexity - O(m + n)
 * Space complexity - O()
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> given = new HashMap<>();
        Map<Character, Integer> curr = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        if(p.length() > s.length()) {
            return res;
        }
        
        // Collect all character occurrences of p
        for(int i = 0; i < p.length(); i++) {
            Integer count = given.get(p.charAt(i));
            if(count == null) {
                count = 1;
            }
            else {
                count++;
            }
            given.put(p.charAt(i), count);
        }
        
        // Set window to the start
        int left = 0;
        int right = p.length() - 1;
        int pos = 0;
        
        while(right < s.length()) {
            boolean wild = false;
            if(pos < left) {
                pos = left;
            }
            // Check if every element in window is in p and add to curr map
            while(pos <= right) {
                // Character exists in p - add to curr
                if(given.get(s.charAt(pos)) != null) {
                    // If it is already seen once, increment count
                    if(curr.get(s.charAt(pos)) != null) {
                        int charCount = curr.get(s.charAt(pos));
                        curr.put(s.charAt(pos), ++charCount);
                    }
                    else {
                        curr.put(s.charAt(pos), 1);
                    }
                }
                // Character is not in p - move left to the right of pos and clear characters from curr before pos
                else {
                    for(int j = left; j < pos; j++) {
                        curr.remove(s.charAt(j));
                    }
                    left = pos + 1;
                    right = left + p.length() - 1;
                    wild = true;
                    break;
                }
                pos++;
            }
            if(wild) { 
                continue;
            }
            
            // Check if window contains an anagram of p
            boolean found = false;
            if(given.size() == curr.size()) {
                found = true;
                for(Map.Entry<Character, Integer> entry : given.entrySet()) {
                    Character key = entry.getKey();
                    Integer val = entry.getValue();
                    Integer currVal = curr.get(key);
                    if(!currVal.equals(val)) {
                        found = false;
                        break;
                    }
                }
                if(found) {
                    res.add(left);
                }
            }
            
            // Slide window by one position and clear left
            if(left < s.length() && curr.get(s.charAt(left)) != null && curr.get(s.charAt(left)) > 1) {
                int leftCount = curr.get(s.charAt(left));
                curr.put(s.charAt(left), --leftCount);
            }
            else if(left < s.length()) {
                curr.remove(s.charAt(left));
            }
            left++;
            right++;
        }
        
        return res;
    }
}
