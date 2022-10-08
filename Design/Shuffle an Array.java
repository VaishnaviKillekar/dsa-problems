// Link to problem - https://leetcode.com/problems/shuffle-an-array/

/**
 * Intuition - Use Java's Random class to get random indices and swap those elements.
 * Random's nextInt() generates random number in constant time.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
import java.util.Random;

class Solution {

    int[] nums;
    Random rand;
    
    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        int[] copy = nums.clone();
        for(int i = nums.length - 1; i > 0; i--) {
            // Random index between 0 to i - add 1 to avoid 0
            int j = rand.nextInt(i + 1);
            
            // Swap the elements at i and j
            int t = copy[i];
            copy[i] = copy[j];
            copy[j] = t;
        }
        return copy;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
