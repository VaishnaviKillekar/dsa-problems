// Link to problem - https://leetcode.com/problems/longest-substring-without-repeating-characters/

/**
 * Intuition - Sliding window
 * Start adding characters to the window and a map to track read elements with their
 * indices. When a duplicate character is read, slide the window forward from the
 * position next to the first instance of the duplicate character.
 * Remove all map entries whose index lies before the first instance of the duplicate
 * character.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int i = 0;
        
        while(i < s.length()) {
            Integer pos = map.get(s.charAt(i));
            // Duplicate found
            // Check current length and reset max if substring is longer
            // Remove all elements found before the first instance of duplicate
            if(pos != null) {
                max = map.size() > max ? map.size() : max;
                map.values().removeIf(value -> value < pos);
            }
            map.put(s.charAt(i), i);
            i++;
        }
        
        return map.size() > max ? map.size() : max;
    }
}



class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        int max = 0;
        
        for(int i = 0; i < s.length(); i++) {
            Integer index = map.get(s.charAt(i));
            if(index != null) {
                // remove all characters before index
                removeCharacters(map, s, index);
            }
            map.put(s.charAt(i), i);
            if(map.size() > max) {
                max = map.size();
            }
        }
        return max;
    }
    
    public void removeCharacters(Map<Character, Integer> map, String s, Integer index) {
        for(Iterator<Map.Entry<Character, Integer>> iter = map.entrySet().iterator();
           iter.hasNext();
           ) {
           Map.Entry<Character, Integer> entry = iter.next(); 
            if(entry.getValue() <= index) {
                iter.remove();
            }
        }
    }
}
