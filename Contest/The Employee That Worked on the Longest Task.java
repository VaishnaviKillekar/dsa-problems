// Link to problem - https://leetcode.com/contest/weekly-contest-314/problems/the-employee-that-worked-on-the-longest-task/

/**
 * Intuition - Scan through the matrix 'logs'. Compare the time of that employee with
 * previous. If duration is longer than the 'longest', then update 'longest' and 'emp'.
 * If equal, then 'emp' is the employee with lower value.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 *
 * Difficulty - Easy | Weekly Contest 314
 */
class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int longest = logs[0][1];
        int emp = logs[0][0];
        int smallId = logs[0][0];
        
        for(int i = 1; i < logs.length; i++) {
            int time = logs[i][1] - logs[i - 1][1];
            if(longest <= time) {
                smallId = (longest == time)? Math.min(smallId, logs[i][0]) : logs[i][0];
                emp = smallId;
                longest = time;
            }
        }
        
        return emp;
    }
}
