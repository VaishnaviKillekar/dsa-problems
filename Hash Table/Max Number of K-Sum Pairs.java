// Link to problem - https://leetcode.com/problems/max-number-of-k-sum-pairs/description/

/**
 * Intuition - Every pair of numbers that sums up to k has to be less than k as nums contains only positive numbers. 
 * We store the number of occurrences of each number in a map and then check how many k-sum pairs are present.
 * Iterate through nums and store the count of occurrence of each number in a map numCount. 
 * Now iterate through the map and for each number num verify if the other number in the pair num - k is present. 
 * If yes, then reduce the count for both and increment max. Do this until the count becomes zero. 
 * Special case to consider is when both the numbers in the pair are the same. Then we go to if else case. 
 * For e.g. if k = 4 and we have two occurrences of number 2, then we decrement count twice.
 * We iterate the array only once and the map n times in worst case.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();
        int max = 0;

        for(int num : nums) {
            if(num < k) {
                int count = numCount.getOrDefault(num, 0);
                numCount.put(num, count + 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            while(count > 0) {
                if (numCount.get(k - num) != null && numCount.get(k - num) > 0 && num != k - num) {
                    count--;
                    numCount.put(num, count);
                    numCount.put(k - num, numCount.get(k - num) - 1);
                    max++;
                }
                else if (numCount.get(k - num) != null && numCount.get(k - num) > 1 && num == k - num) {
                    count -= 2;
                    numCount.put(num, count);
                    max++;
                }
                else {
                    break;
                }
            } 
        }

        return max;
    }
}
