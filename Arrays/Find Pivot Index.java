// Link to problem - https://leetcode.com/problems/find-pivot-index/

/**
 * Intuition - Concise linear search
 * First find the sum of elements except the first and that forms the rightmost sum 'right'.
 * Initially leftmost sum 'left' is zero indicating the left of array with 0th element as
 * pivot. Scan the array and compare 'left' and 'right'. If they are equal, return current
 * index as pivot. Otherwise, increment 'left' using current element and decrement 'right'
 * by next element so as to move the pivot to next element.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int pivotIndex(int[] nums) {
        int left = 0;   // Sum of leftmost elements
        int right = 0;      // Sum of rightmost elements

        for(int i = 1; i < nums.length; i++) {
            right += nums[i];
        }

        // Iterate through array and compare left and right sum
        for(int i = 0; i < nums.length; i++) {
            if(left == right) {
                return i;
            }
            else {
                left += nums[i];
                right = i < nums.length - 1 ? right - nums[i + 1] : 0;
            }
        }

        return -1;
    }
}


class Solution {
    public int pivotIndex(int[] nums) {
        int left = 0;
        int right = getRightSum(nums);
        int pos = 0;
        
        while(pos < nums.length && (pos+1 < nums.length) && left != right) {
            left += nums[pos];
            right -= nums[pos+1];
            pos++;
        }
        
        if(left == right)
            return pos;
        return -1;
    }
    
    public int getRightSum(int[] nums) {
        int sum = 0;
        for(int i=1; i<nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
