// Link to problem - https://leetcode.com/problems/3sum/

/**
 * Intuition - Use two-pointer technique to start with the element right after current i and last element in the array.
 * The array is sorted at first and then for every i, we find two elements whose sum with i equals zero.
 * If sum of two pointers is lower than expected, then advance low pointer as it points to smaller elements.
 * Else if sum of two pointersis higher than expected, then decrement high pointer.
 * If the element at i and i+1 are the same, then advance i as it leads to duplicate tuples (line 18).
 *
 * Time complexity - O(n^2)
 * Space complexity - O(n)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];

                while(low < high) {
                    if(nums[low] + nums[high] == sum) {
                        triplets.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    }
                    else if(nums[low] + nums[high] < sum) {
                        low++;
                    }
                    else {
                        high--;
                    }
                }
            }
        }
        
        return triplets;
    }
}