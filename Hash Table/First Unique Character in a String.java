// Link to problem - https://leetcode.com/problems/first-unique-character-in-a-string/

/**
 * Intuition - This problem can be solved in two approaches -
 * 1. Store the occurrences of elements in a Map in first pass. In second pass, check
 * if the number of occurrences of current element in the Map is 1 and return it.
 *
 * 2. The below code uses this approach which also works for input sent as continuous
 * stream. Here the Set 'seen' stores elements that have been found. LinkedHashMap
 * stores the elements along with their indices when they're found for the first time.
 * If an element is found a second time, that element is removed from the LinkedHashMap.
 * This ensure that the LinkedHashMap contains only unique elements.
 * After all elements are scanned, if the 'unique' LinkedHashMap does not contains any
 * elements, then there is no unique element in the string. Otherwise, return the
 * element at the first index (this is why a LinkedHashMap in used to maintain order
 * of insertion of elements).
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public int firstUniqChar(String s) {
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> unique = new LinkedHashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            Character curr = s.charAt(i);
            if(seen.contains(curr)) {
                if(unique.get(curr) != null) {
                    unique.remove(curr);
                }
            }
            else {
                seen.add(curr);
                unique.put(curr, i);
            }
        }
        
        return unique.size() == 0? -1 : unique.entrySet().iterator().next().getValue();
    }
}
