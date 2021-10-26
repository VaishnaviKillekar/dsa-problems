// Link to problem - https://leetcode.com/problems/find-pivot-index/

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