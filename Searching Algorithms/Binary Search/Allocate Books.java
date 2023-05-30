// Link to problem - https://www.codingninjas.com/codestudio/problems/allocate-books_1090540

/**
 * Intuition - Use Binary Search to find the least number of pages that can be assigned to
 * each student.
 *
 * Time complexity - O(logn)
 * Space complexity - O(1)
 */
import java.util.ArrayList;
public class Solution {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        int start = 0;
        int end;
        int sum = 0;
        int ans = -1;

        // No. of students can't be greater than no. of books
        if(m > n) {
            return ans;
        }

        // Get the maximum possible books that can be assigned
        for(int i = 0; i < n; i++) {
            sum += arr.get(i);
        }
        end = sum;

        // Check if a solution exists using Binary Search
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(isPossible(arr, n, m, mid)) {
                ans = mid;  // Assign new minimum
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(ArrayList<Integer> arr, int n, int m, int mid) {
        int student = 1;    // Current student being allocated books
        int pages = 0;
        
        for(int i = 0; i < n; i++) {
            if(pages + arr.get(i) <= mid) {
                pages += arr.get(i);
            }
            else {
                // Book pages allocated is greater than mid, move to next student
                student++;
                // No. of remaining books has exceeded students or current pages is larger than allowed minimum, 'mid'
                if(student > m || arr.get(i) > mid) {
                    return false;
                }
                pages = arr.get(i);     // Allocate current book to next student
            }
        }
        return true;
    }
}
