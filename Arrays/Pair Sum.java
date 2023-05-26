// Link to problem - https://www.codingninjas.com/codestudio/problems/pair-sum_697295?leftPanelTab=0

/**
 * Intuition - Use a simple nested loop to check current element with all elements after it
 * whose sum is equal to s. Add them in sorted order to result. Also define a comparator to
 * further sort the result of arrays.
 *
 * Time complexity - O(nlogn)
 * Space complexity - O(1)
 */
import java.io.*;
import java.util.* ;

public class Solution{
    public static List<int[]> pairSum(int[] arr, int s) {
        List<int[]> result = new ArrayList<int[]>();

        Comparator<int[]> comparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        }
      };

        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] == s) {
                    int min = Math.min(arr[i], arr[j]);
                    int max = Math.max(arr[i], arr[j]);
                    result.add(new int[] {min, max});
                }
            }
        }
        Collections.sort(result, comparator);
        return result;
    }
}
