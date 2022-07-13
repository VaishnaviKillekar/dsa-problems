// Link to problem - https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

/**
 * Intuition - Binary Search approach
 * Scan through the array and for each element, run a binary search to find
 * the other element whose sum with the current element matches the target.
 *
 * Time complexity - O(nlogn)
 * Space complexity - O(1)
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        
        int i;
        int index = -1;
        for(i = 0; i < numbers.length; i++) {
            int key = target - numbers[i];
            index = binarySearch(numbers, key, i);
            if(index != -1) {
                break;
            }
        }
        
        res[0] = i > index ? index + 1 : i + 1;
        res[1] = i < index ? index + 1 : i + 1;
        return res;
    }
    
    public int binarySearch(int[] numbers, int key, int curr) {
        int left = 0;
        int right = numbers.length - 1;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            if(curr != mid && numbers[mid] == key) {
                return mid;
            }
            else if(numbers[mid] > key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
