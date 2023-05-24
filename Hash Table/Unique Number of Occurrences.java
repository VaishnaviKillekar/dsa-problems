// Link to problem - https://leetcode.com/problems/unique-number-of-occurrences/description/

/**
 * Intuition - Sort the given array and then count the number of
 * occurrences of each element and store it in a set. While adding
 * to set, check if such a count already exists. If yes, return
 * false. Otherwise, return true if all occurrences were added to
 * the set without any duplicates.
 *
 * Time complexity - O(n logn)
 * Space complexity - O(n)
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> set = new HashSet<>();

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++) {
            int j = i + 1;
            int count = 1;
            while(j < arr.length && arr[j] == arr[i]) {
                j++;
                count++;
            }
            if(!set.add(count)) {
                return false;
            }
            i = j - 1;
        }

        return true;
    }
}


/**
 * Intuition - Scan the given array and add the number of occurrences
 * in a map. Now iterate through the map and check if the values are
 * unique or not by adding them to a set. If set.add() returns false,
 * then a duplicate occurrence was found - return false. Otherwise,
 * return true.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> count = new HashSet<>();

        for(int num : arr) {
            Integer occurrences = map.get(num);
            if(occurrences == null) {
                occurrences = 0;
            }
            map.put(num, occurrences + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(!count.add(entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
