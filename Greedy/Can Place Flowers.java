// Link to problem - https://leetcode.com/problems/can-place-flowers/

/**
 * Intuition - Greedy approach - place flowers whenever a slot is available.
 * Start with a counter 'count' set to 0 and increment it when a slot is filled.
 * Continue to do it until we have reached the end of the array or all flowers
 * are successfully placed.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        int count = 0;

        while(i < flowerbed.length && count < n) {
            if(flowerbed[i] == 0) {
                int left = i != 0 ? flowerbed[i-1] : 0;
                int right = i != flowerbed.length - 1 ? flowerbed[i+1] : 0;
                
                if(left == 0 && right == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
            }     
            i++;
        }
        
        return count == n;
    }
}
