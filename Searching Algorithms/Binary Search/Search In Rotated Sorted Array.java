// Link to problem - https://www.codingninjas.com/codestudio/problems/search-in-rotated-sorted-array_1082554

/**
 * Intuition - Find the pivot index at which the sorted array was rotated. Now check if the key
 * is greater than pivot element and smaller than the last element, then search to the right of pivot.
 * Otherwise, search to the left of pivot.
 *
 * Time complexity - O(logn)
 * Space complexity - O(1)
 */
import java.util.ArrayList;
public class Solution {
    public static int search(ArrayList<Integer> arr, int n, int k) {
        int left = 0;
        int right = n - 1;
        int pivot;

        // Find the pivot
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr.get(mid) >= arr.get(0)) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        pivot = left;
        
        if(k >= arr.get(pivot) && k <= arr.get(n - 1)) {
            left = pivot;
            right = n - 1;
        }
        else {
            left = 0;
            right = pivot - 1;
        }

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr.get(mid) == k) {
                return mid;
            }
            else if(arr.get(mid) > k) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
