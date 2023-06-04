// Link to problem - https://www.codingninjas.com/codestudio/problems/reverse-the-array_1262298


/**
 * Intuition - Two-pointer approach
 * Use teo pointers which point to the index after m and end of array - the
 * section which needs to be reversed.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static void reverseArray(ArrayList<Integer> arr, int m)
    {
        int i = m + 1;
        int j = arr.size() - 1;

        while(i < j) {
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }
    }
}
