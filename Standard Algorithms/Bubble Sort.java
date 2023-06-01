/**
 * Intuition - 
 * Compare the adjacent elements and swap when they are out of order. 
 * After every pass i, the ith largest element gets placed at its correct
 * position. Do this for 'n - 1' passes to sort all n elements.
 *
 * Consider ex: [5,9,1,4,2,8]
 * Pass 1: [5,9,1,4,2,8] -> [5,1,9,4,2,8] -> [5,1,4,9,2,8] -> [5,1,4,2,9,8] -> [5,1,4,2,8,9]  - 9 is sorted
 * Pass 2: [1,5,4,2,8,9] -> [1,4,5,2,8,9] -> [1,4,2,5,8,9] -> [1,4,2,5,8,9]                   - 8 is sorted
 * Pass 3: [1,4,2,5,8,9] -> [1,2,4,5,8,9] -> [1,2,4,5,8,9]                                    - 5 is sorted
 * Pass 4: [1,2,4,5,8,9] -> [1,2,4,5,8,9]                                                     - 4 is sorted
 * Pass 5: [1,2,4,5,8,9]                                                                      - 2 is sorted
 *
 * This is a stable algorithm as relative ordering of elements is not disturbed
 * when adjacent elements are compared and swapped.
 *
 * Time complexity - O(n^2)
 * Space complexity - O(1)
 */
public class Solution {
    public static void bubbleSort(int[] arr, int n) {   
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

/**
 * Optimised solution - checks if there were swaps in a pass. If there were no swaps, then array
 * is already sorted. No need to continue sort. Otherwise, continue sort.
 *
 * This improves the time complexity for fully and partially sorted arrays.
 */
public class Solution {    
    public static void bubbleSort(int[] arr, int n) {   
        for(int i = 0; i < n; i++) {
            boolean swapped = false;
            for(int j = 0; j < n - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    swapped = true;
                    swap(arr, j, j + 1);
                }
            }
            if(!swapped) {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
