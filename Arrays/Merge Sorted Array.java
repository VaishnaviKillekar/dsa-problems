// Link to problem - https://leetcode.com/problems/merge-sorted-array/

/**
 * Intuition - Start scanning both arrays backward as they are already sorted.
 * Compare elements of the arrays and the larger one must be added to the end of the larger array.
 *
 * Time complexity - O(m+n)
 * Space complexity - o(1)
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1;
        int q = n - 1;
        int i = nums1.length - 1;
        
        while(p >= 0 && q >= 0) {
            if(nums1[p] > nums2[q]) {
                nums1[i--] = nums1[p--];
            }
            else {
                nums1[i--] = nums2[q--];
            }
        }
        
        while(p >= 0) {
            nums1[i--] = nums1[p--];
        }

        while(q >= 0) {
            nums1[i--] = nums2[q--];
        }
    }
}
