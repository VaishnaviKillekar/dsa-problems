/**
 * Intuition - The most efficient way to compute power of a number is dividing the power in
 * half until it becomes zero and then computing the result.
 * Consider a^b,
 * When power b is even, we simplify as -  (a ^ (b/2)) ^ 2
 * When power b is odd, we simplify as -   a * ((a ^ (b/2)) ^ 2)
 * Continue this process using recursion until b becomes zero, then the value evaluates to 1.
 *
 * For ex: 2 ^ 10 (2 power 10)
 * 10 is even: 2 ^ 10 ==> (2 ^ 5) ^ 2
 * 5 is odd:   2 ^ 5  ==>  2 * ((2 ^ 2) ^ 2)
 * 2 is even:  2 ^ 2  ==> (2 ^ 1) ^ 2
 * 1 is odd:   2 ^ 1  ==> 2 * (2 ^ 0) ^ 2
 *
 * Time complexity - O(logn base 2)
 * Space complexity - O(logn base 2)
 */
class Solution {
  public static void main(String[] args) {
    // Find a^b
    long a = 2;
    long b = 10;

    System.out.println(power(a, b));
  }

  public static long power(long a, long b) {
    // Base case a^0 => 1
    if(b == 0) {
      return 1;
    }

    long val = power(a, b/2);

    if(b % 2 == 0) {
      // Even power - a^b = (a^(b/2))^2
      return val * val;
    }
    else {
      // Odd power - a^b = a * (a^(b/2))^2
      return a * val * val;
    }
  }
}
