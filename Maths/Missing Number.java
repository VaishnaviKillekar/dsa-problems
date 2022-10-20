// Link to problem - https://leetcode.com/problems/missing-number/

/**
 * Intuition - Add all natural numbers 1 to length of nums (n).
 * Subtract the numbers from sum. The remaining value of sum is the missing number.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            // Add all numbers between 1 to n
            sum += i + 1;
            
            // Subtract the current number from sum
            sum -= nums[i];
        }
        
        // Return remaining as this is the missing number
        return sum;
    }
}


/**
 * Intuition - Do an XOR all natural numbers 1 to n-1 along with nums[i] in a loop.
 * Do a final XOR with nth natural number. The XOR value is the missing number.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
public int missingNumber(int[] nums) {

    int xor = 0;
    int i = 0;
  
    // XOR of natural number with nums[i] gives missing number
    for (i = 0; i < nums.length; i++) {
      xor = xor ^ i ^ nums[i];
    }

    // Do a final XOR of the nth natural number as loop only goes till n-1
	  return xor ^ i;
}
