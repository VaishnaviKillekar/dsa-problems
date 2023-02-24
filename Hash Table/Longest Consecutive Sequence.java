// Link to problem - https://leetcode.com/problems/longest-consecutive-sequence/description/

/**
 * Intuition - HashSet to maintain array elements are O(1) access
 * Scan through the array and add elements to the HashSet. Now iterate through the array and 
 * check if current element is first in the consecutive elements streak i.e. there should not
 * exist an element nums[i]- 1. So nums[i] is the first element in streak.
 * Now keep checking consecutive elements exist by incrementing nums[i] by 1 until 'next' does
 * not exist.
 * Reset length when elements are not consecutive and update 'longest' if 'length' was longer.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;

        // Add elements to set
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // Scan the array and check for consecutive numbers using set
        for(int i = 0; i < nums.length; i++) {
            // nums[i] is the first element of the sequence
            if(!set.contains(nums[i] - 1)) {
                int next = nums[i] + 1;
                int count = 1;
                // Check if next consecutive element exists
                while(set.contains(next)) {
                    count++;
                    next++;
                }
                longest = Math.max(count, longest);
            }
        }

        return longest;
    }
}


/**
 * Intuition - TreeSet to get sorted array
 * Scan through the array and add elements to the TreeSet. This will sort it without duplicates.
 * Now iterate through the TreeSet and increment 'length' when elements are consecutive.
 * Reset length when elements are not consecutive and update 'longest' if 'length' was longer.
 * 
 * There is a possibility where elements are consecutive till the end of TreeSet, so return the
 * maximum of 'length' and 'longest' as 'longest' is only updated in the loop when elements are
 * no longer consecutive.
 *
 * Time complexity - O(nlogn) - TreeSet add takes O(logn) time
 * Space complexity - O(n)
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        int longest = 0;
        int length = 1;

        if(nums.length == 0) { 
            return longest;
        }
        
        // Add all elements in sorted order in set
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // Find the longest sequence
        Integer prev = null;
        for(Integer curr : set) {
            if(prev != null && prev + 1 == curr) {
                length++;
            }
            else {
                longest = Math.max(length, longest);
                length = 1;
            }
            prev = curr;
        }

        return Math.max(length, longest);
    }
}
