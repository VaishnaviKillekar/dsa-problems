// Link to problem - https://leetcode.com/problems/largest-number-at-least-twice-of-others/

class Solution {
    public int dominantIndex(int[] nums) {
        int largestIndex = 0;
        
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > nums[largestIndex]) {
                largestIndex = i;
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(i != largestIndex && (2 * nums[i] > nums[largestIndex])) {
                return -1;
            }
        }
        return largestIndex;
    }
}