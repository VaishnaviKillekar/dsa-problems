// Link to problem - https://leetcode.com/problems/group-anagrams/

/**
 * Intuition - Sort each string to get a common string for a group of Anagram so it can be key to the HashMap.
 * When sorted string matches the key, then group the anagram or create a new entry.
 *
 * Time complexity - O(n * mlogn) - Sort each string - mlogn where m is its length
 * Space complexity - O(n)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        
        for(String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            List<String> list = new ArrayList<>();
            if(group.get(key) != null) {
                list = group.get(key);
            }
            list.add(str);
            group.put(key, list);
        }
        
        for(Map.Entry<String, List<String>> entry : group.entrySet()) {
            result.add(entry.getValue());
        }
        
        return result;
    }
}
