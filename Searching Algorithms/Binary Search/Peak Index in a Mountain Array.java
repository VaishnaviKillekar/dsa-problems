// Link to problem - https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

/**
 * Intuition - Use Binary Search to find an element which greater than its left and right.
 *
 * Time complexity - O(logn)
 * Space complexity - O(1)
 */
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(mid > 0 && mid < arr.length - 1 && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            else if((mid > 0 && arr[mid] > arr[mid - 1]) || (mid < arr.length - 1 && arr[mid] < arr[mid + 1])) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
