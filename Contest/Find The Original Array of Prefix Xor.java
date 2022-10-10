// Link to problem - https://leetcode.com/contest/weekly-contest-314/problems/find-the-original-array-of-prefix-xor/

/**
 * Intuition - Assign the first element in 'arr' as is from 'pref'.
 * From second element, do an XOR of current 'pref' with XOR of all
 * 'arr' elements so far.
 *
 * XOR property: 3 ^ X = 5 <==> 3 ^ 5 = X   [Both are equivalent]
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 *
 * Difficulty - Medium | Weekly Contest 314
 */
class Solution {
    public int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];
        int xor = pref[0];
        
        arr[0] = pref[0];
        
        for(int i = 1; i < pref.length; i++) {
            arr[i] = xor ^ pref[i];
            xor ^= arr[i];
        }
        
        return arr;
    }
}
