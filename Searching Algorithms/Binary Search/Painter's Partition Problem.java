// Link to problem - https://www.codingninjas.com/codestudio/problems/painter's-partition-problem_1089557

/**
 * Intuition - use binary search to find a minimum length to be painted by each painter.
 * A painter can only paint length less than or equal to current minimum, 'mid'.
 *
 * Time complexity - O(logn)
 * Space complexity - O(1)
 */
import java.util.ArrayList;

public class Solution 
{
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int min = -1;
        int start = 0;
        int end = 0;

        // No. of painters can't be greater than no. of boards
        if(k > boards.size()) {
            return min;
        }

        // Max possible time required
        for(int i = 0; i < boards.size(); i++) {
            end += boards.get(i);
        }

        // Get the minimum time required using Binary Search
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(isPossible(boards, k, mid)) {
                min = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return min;
    }

    public static boolean isPossible(ArrayList<Integer> boards, int k, int mid) {
        int painter = 1;    // Current painter
        int length = 0;     // Total board length assigned to painter

        for(int i = 0; i < boards.size(); i++) {
            if(length + boards.get(i) <= mid) {
                length += boards.get(i);
            }
            else {
                painter++;  // Move to next painter
                if(painter > k || boards.get(i) > mid) {
                    // No more painters left or current board length is higher than minimum, mid
                    return false;
                }
                length = boards.get(i);     // Assign current board length to next painter
            }
        }

        return true;
    }
}
