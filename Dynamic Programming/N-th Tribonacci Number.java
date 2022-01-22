// Link to problem - https://leetcode.com/problems/n-th-tribonacci-number/

/**
 * Intuition - This is a simple extension of the Fibonacci series. The three variables to generate the next number are stored
 * in variables a, b and c. We can also store all results in an array which will make the space complexity - O(n).
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int tribonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        
        if(n == 0 || n == 1) {
            return n;
        }
        else if(n == 2) {
            return a + b;
        }
        
        for(int i = 3; i <= n; i++) {
            int sum = a + b + c;
            a = b;
            b = c;
            c = sum;
        }
        
        return c;
    }
}
