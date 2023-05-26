// Link to problem - https://leetcode.com/problems/sort-colors/description/

/**
 * Intuition - One-pass solution
 * Maintain three pointers where i is incremented for 0s, k is incremented for 2s.
 * j is used as a current pointer such that 1s are between i and j.
 * When 0 is found, swap elements at position i and j and increment both pointers.
 * When 2 is found, swap elements at position j and k and decrement k pointer. Let
 * j be at the same position to ensure that swapped element is at its right place.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public void sortColors(int[] nums) {
        int i = 0;                  // Pointer to 0s. 0s lie to the left of i
        int j = 0;                  // Current pointer. 1s lie between i and j
        int k = nums.length - 1;    // Pointer to 2s. 2s lie to the right of k

        while(j <= k) {
            if(nums[j] == 0) {
                swap(nums, i++, j++);
            }
            else if(nums[j] == 2) {
                swap(nums, j, k--);
            }
            else {
                j++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}


/**
 * Intuition - Alternate one-pass solution
 * Set the 'zero' and 'two' pointers outside the array on extreme ends. 'curr' points to
 * current element in the array. When a 0 or 2 is found by 'curr', then increment or
 * decrement the 'zero' and 'two' pointer first and swap them with 'curr'.
 * If 'curr' and 'zero'/'two' pointers point to the same index, then increment 'curr' as
 * element is in it's correct place.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static void sort012(int[] arr)
    {
        int zero = -1;
        int two = arr.length;
        int curr = 0;

        while(curr < arr.length) {
            if(arr[curr] == 0) {
                zero++;
                swap(arr, curr, zero);
                if(zero == curr) curr++;
            }
            else if(arr[curr] == 2 && curr < two) {
                two--;
                swap(arr, curr, two);
                if(two == curr) curr++;
            }
            else {
                curr++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


/**
 * Intuition - Two-pass solution
 * Maintain three counters 'zero', 'one' and 'two' to store the number of occurrences
 * of 0s, 1s and 2s.
 * Iterate the array once and increment respective counters to store the exact count.
 * 
 * Now iterate through the array again and replace the beginning of the array with
 * 0s based on count 'zero'. Similarly, for 1s and 2s.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zero++;
            }
            else if(nums[i] == 1) {
                one++;
            }
            else {
                two++;
            }
        }

        int i = 0;
        while(i < nums.length && zero > 0) {
            nums[i++] = 0;
            zero--;
        }
        while(i < nums.length && one > 0) {
            nums[i++] = 1;
            one--;
        }
        while(i < nums.length && two > 0) {
            nums[i++] = 2;
            two--;
        }
    }
}
