// Link to problem - https://leetcode.com/problems/fibonacci-number/description/

/**
 * Intuition - Recursive approach
 * Recurrence relation: f(n) = f(n - 1) + f(n - 2)
 *
 * Since each function calls two branches and this happens for all n - time becomes 2^n.
 * Recursion tree in the worst case has n levels - hence space becomes n
 *
 * Time complexity - O(2^n) - [tight upper bound: O(1.6180^n) - golden ratio]
 * Space complexity - O(n)
 */
class Solution {
    public int fib(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}

/**
 * Intuition - Dynamic programming with memoization approach
 * Recurrence relation: f(n) = f(n - 1) + f(n - 2)
 *
 * Each function calls two branches but we store each computed result, hence we avoid
 * duplicate computations which brings down the time taken to n.
 * We store all results, hence space required is n.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public int fib(int n) {
        if(n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i < dp.length; i++) {
            dp[i] = -1;
        }

        return getFib(n, dp);
    }

    public int getFib(int n, int[] dp) {
        if(dp[n] != -1) {
            return dp[n];
        }
        dp[n] = getFib(n - 1, dp) + getFib(n - 2, dp);
        return dp[n];
    }
}


/**
 * Intuition - Iterative approach
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int fib(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        int a = 0;
        int b = 1;
        int c = 0;
      
        for(int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }
}
