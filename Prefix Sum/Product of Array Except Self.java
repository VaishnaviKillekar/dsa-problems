// Link to problem - https://leetcode.com/problems/product-of-array-except-self/

/**
 * Intuition - Prefix and Suffix sum
 * Since result must contain the product of all elements except that element at that position,
 * compute the product at the prefix (all elements to left) and suffix (all elements to right)
 * at each position.
 * While computing suffix, maintain a product variable 'prod' to store the current element so
 * it can be multiplied to the next element and not itself.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        
        // Multiply elements from left to right - prefix
        answer[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        // Multiply elements from right to left - suffix
        int prod = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= prod;
            prod *= nums[i];
        }
        
        return answer;
    }
}
