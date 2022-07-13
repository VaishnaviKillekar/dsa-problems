// Link to problem - https://leetcode.com/problems/move-zeroes/

/**
 * Intuition - Check for non-zero elements by scanning the array from start to end.  
 * When a non-zero element is found, incremement the 'nonZero' counter and replace
 * the array element at 'nonZero' index with current non-zero element. Element is
 * replaced irrespective of the element at 'nonZero' index.
 * In this way, we move all non-zero elements to the left and the position of 
 * 'nonZero' index will be the last non-zero element. We then replace all positions
 * after it as zero.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int nonZero = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[nonZero++] = nums[i];
            }
        }
        
        for(int i = nonZero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

/**
 * Intuition - Two pointer approach
 * Maintain two pointers - 'zero' and 'curr' which point to the elements of value zero and non-zero.
 * If the zero element occurs after non-zero element, then swap. Then find the next zero and 
 * non-zero element and repeat.
 * If the npn-zero element occurs after the zero element, then search for next zero element without
 * swapping as zeroes should be moved to the right end of array.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int zero = findZero(nums, 0);
        int curr = findNonZero(nums, 0);
        
        while(zero != -1 && curr != -1) {
            if(zero < curr) {
                nums[zero] = nums[curr];
                nums[curr] = 0;
                zero = findZero(nums, ++zero);
                curr = findNonZero(nums, ++curr);
            }
            else {
                curr = findNonZero(nums, ++curr);
            }
        }
    }
    
    public int findNonZero(int[] nums, int curr) {
        while(curr < nums.length && nums[curr] == 0) {
            curr++;
        }
        return curr >= nums.length ? -1 : curr;
    }
    
    public int findZero(int[] nums, int zero) {
        while(zero < nums.length && nums[zero] != 0) {
            zero++;
        }
        return zero >= nums.length ? -1 : zero;
    }
}
