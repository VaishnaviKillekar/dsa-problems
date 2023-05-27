// Link to problem - https://www.codingninjas.com/codestudio/problems/first-and-last-position-of-an-element-in-sorted-array_1082549

/**
 * Intuition - Use Binary Search to search once only the left side of the array once an occurrence
 * of key is found and then search to the right of array once an occurrence is found.
 *
 * Time complexity - O(logn)
 * Space complexity - O(1)
 */
import java.util.* ;
import java.io.*; 
public class Solution {

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        int first = -1;
        int last = -1;
        int left = 0;
        int right = n - 1;
        int[] result = new int[2];

        first = searchLeft(arr, k, 0, n - 1);
        last = searchRight(arr, k, 0, n - 1);
        result[0] = first;
        result[1] = last;

        if(first == -1 || last == -1) {
            result[0] = Math.max(first, last);
            result[1] = Math.max(first, last);
        }

        return result;
    }

    public static int searchLeft(ArrayList<Integer> arr, int key, int left, int right) {
        int first = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr.get(mid) == key) {
                first = mid;
                right = mid - 1;
            }
            else if(arr.get(mid) > key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return first;
    }

    public static int searchRight(ArrayList<Integer> arr, int key, int left, int right) {
        int last = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr.get(mid) == key) {
                last = mid;
                left = mid + 1;
            }
            else if(arr.get(mid) > key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return last;
    }
};


// LeetCode

// Link to problem - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

/**
 * Intuition - Run a binary search on given array until the target is found. Mark `mid` as the
 * `left` and `right` of the window to expand.
 * Now grow this window on the left and right until the elements are equal to the target.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

        // Find any occurrence of the target using Binary Search
        while(left < right) {
            mid = (left + right) / 2;
            if(nums[mid] == target) {
                left = mid;
                right = mid;
                break;
            }
            else if(nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        // Check if Binary Search found the target and then find the first and last occurrence
        if(left == right && nums[left] == target) {
            boolean change = true;
            while(change && (nums[left] == target || nums[right] == target)) {
                change = false;
                if(left > 0 && nums[left - 1] == target) {
                    change = true;
                    left--;
                }
                if(right < nums.length - 1 && nums[right + 1] == target) {
                    change = true;
                    right++;
                }
            }
        }

        // The first condition in this `if` takes care of arrays of size 0, 1 and 2
        if(left <= nums.length - 1 && nums[left] == target) {
            res[0] = left;
            res[1] = right;
        }
        return res;
    }
}
