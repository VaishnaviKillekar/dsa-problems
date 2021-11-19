// Link to problem - https://leetcode.com/problems/two-sum/


// O(n) solution using HashMap

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap();
        Integer numIndex = -1;
        int i;
        
        for(i = 0; i < nums.length; i++) {
            numIndex = indices.get(target - nums[i]);
            if(numIndex != null) {
                break;
            }
            indices.put(nums[i], i);
        }
        return new int[]{numIndex, i};
    }
}