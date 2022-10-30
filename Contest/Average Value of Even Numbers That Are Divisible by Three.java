// Link to problem - https://leetcode.com/contest/weekly-contest-317/problems/average-value-of-even-numbers-that-are-divisible-by-three/


/**
 * Weekly Contest 317
 *
 * Intuition - Check if current array element is even and divisible by 3 by using modulus operator.
 * Sum up all such elements and keep a count. Finally, return average if sum is not zero.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0 && nums[i] % 3 == 0) {
                sum += nums[i];
                count++;
            }
        }        
        
        return count != 0 ? (sum / count) : count;
    }
}
