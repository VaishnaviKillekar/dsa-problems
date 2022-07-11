// Link to problem - https://leetcode.com/problems/first-bad-version/

/**
 * Intuition - Use Binary Search to scan through the array. If mid is a bad version,
 * then check if the previous one is bad.
 * If previous is bad, then scan through the left half of mid. Else, return mid as
 * first bad version.
 * if mid is not a bad version, scan the right half of mid.
 *
 * Time complexity - O(logn)
 * Space complexity - O(1)
 */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid = left + (right - left) / 2;
        
        while(left <= right) {
            boolean curr = isBadVersion(mid);
            if(curr) {
                if(!isBadVersion(mid-1)) {
                    return mid;
                }
                else {
                    right = mid - 1;
                }
            }
            else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        return -1;
    }
}
