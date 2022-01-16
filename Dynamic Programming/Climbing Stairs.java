// Link to problem - https://leetcode.com/problems/climbing-stairs/

/**
 * Intuition - Dynamic Programming approach
 * To reach any stair, there are two ways - by taking one step or two steps. We could have written a simple recursive function as 
 * public int numOfSteps(int n) {
 *    if n == 0 || n == 1
 *        return 1;  
 *    return numOfSteps(n - 1) + numOfSteps(n - 2)
 * }
 * The problem with this approach is recomputation of already computed values. Draw a recursion tree to find out. To avoid this and reuse values, we
 * can use dynamic programming by storing computed values of each stair and reusing when required.
 *
 * First stair can be climbed in one step.
 * Second stair can be climbed in one step or two steps -> 2 ways.
 * Third stair can be climbed in [1,1,1] or [1,2] or [2,1] -> 3 ways.
 * In this way, nth stair can be climbed in steps taken to climb (n-1 stair + n-2 stair).
 * We can store the number of ways of climbing each step in an array of size n+1 where 0th index represents 0th stair which is assumed to take one step.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 *
 */
class Solution {
    public int climbStairs(int n) {
        int steps[] = new int[n+1];
        steps[0] = 1;
        steps[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            steps[i] = steps[i-1] + steps[i-2];
        }
        
        return steps[n];
    }
}

/**
 * Intuition - Fibonacci series approach
 * Assuming 0th stair takes 1 step to reach and 1st stair takes 1 step.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 *
 */
 class Solution {
    public int climbStairs(int n) {
        int n0 = 1; // step 0
        int n1 = 1; // step 1
        int top = 1;
        
        if(n == 1)
            return top;
        
        for(int i = 2; i <= n; i++) {
            top = n0 + n1;
            n0 = n1;
            n1 = top;
        }
        
        return top;
    }
}
