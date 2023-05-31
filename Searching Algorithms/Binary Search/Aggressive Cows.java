// Link to problem - https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559

/**
 * Intuition - Binary Search
 *
 * How to ascertain Binary Search applies to the problem?
 * -> Since cows need to be placed at max possible distance, we can try out placing them at a specific distance and
 *    check if it is possible to place them all. If there is no solution, then we know that the distance needs to be
 *    increased as current distance does not work. So we are eliminating all lower distances which shows that this
 *    approach reduces one part of the search space each time and this is how Binary Search works.
 *    The distance increases linearly as well which is also another indicator for Binary Search.
 *
 * Start with setting minimum and maximum distance for search space. Minimum can be taken as 0 and maximum distance
 * is the max of array. Sort the stalls so that if cows can't be placed with current max, then when we move to next
 * stall, the distance must increase between stalls.
 *
 * Time complexity - O(nlogn)
 * Space complexity - O(1)
 */
import java.util.*;
public class Solution {
    public static int aggressiveCows(int []stalls, int k) {
        int start = 0;
        int end = -1;
        int maxDistance = -1;

        // Sort the stalls
        Arrays.sort(stalls);

        // Max possible distance at which cows can be placed
        end = stalls[stalls.length - 1];

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(isPossible(stalls, k, mid)) {
                // Cows are not aggresive at mid, then they won't be aggresive at higher distances
                // We need to find the max possible distance so move search space to right of mid
                maxDistance = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return maxDistance;
    }

    public static boolean isPossible(int []stalls, int k, int max) {
        int cow = 1;    // Cow being placed
        int prevCowStall = 0;   // Stall at which last cow was placed

        for(int i = 0; i < stalls.length; i++) {
            if(stalls[i] - stalls[prevCowStall] >= max) {
                cow++;
                prevCowStall = i;
                if(cow == k) {
                    return true;
                }
            }
        }

        return false;
    }
}
