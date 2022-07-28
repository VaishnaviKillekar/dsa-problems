// Link to problem - https://leetcode.com/problems/single-number-iii/

/**
 * Intuition - The array can be divided into two groups where each contains one of the two unique elements.
 * This is done by segregation of elements based on the last set bit. Each of the two unique elements differ
 * in one set bit and here we use the last set bit to divide the elements in groups and do an XOR to get the
 * unique element of each group.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int xor = 0;
        
        // Find XOR of all elements - sum of the two unique numbers
        for(int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        
        // Get the last set bit using low bit formula
        // This is the bit where the two unique numbers differ
        xor &= -xor;
        
        // The entire array is divided into two groups
        // Numbers which have the last set bit (xor) as 0 and 1.
        // In each group, one of the result element is unique which shares the same bit.
        for(int num : nums) {
            if((num & xor) == 0) {
                res[0] ^= num;
            }
            else {
                res[1] ^= num;
            }
        }
        
        return res;
    }
}
