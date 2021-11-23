// Link to problem - https://leetcode.com/problems/longest-substring-without-repeating-characters/


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