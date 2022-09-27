// Link to problem - https://leetcode.com/problems/intersection-of-two-arrays-ii/

/**
 * Intuition - Store the number of occurrences of elements from nums1 in a map.
 * Scan through nums2 and if the element is available in map, then add to result.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < nums1.length; i++) {
            Integer count = map.get(nums1[i]);
            if(count != null) {
                count++;
            }
            else {
                count = 1;
            }
            map.put(nums1[i], count);
        }
        
        for(int i = 0; i < nums2.length; i++) {
            Integer count = map.get(nums2[i]);
            if(count != null) {
                result.add(nums2[i]);
                count--;
                if(count > 0) {
                    map.put(nums2[i], count);
                }
                else {
                    map.remove(nums2[i]);
                }
            }
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
}
