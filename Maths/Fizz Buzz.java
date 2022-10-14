// Link to problem - https://leetcode.com/problems/fizz-buzz/

/**
 * Intuition - Check if modulo operation of n with 3, 5 and 15
 * returns 0.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            if(i % 15 == 0) {
                s = "FizzBuzz";
            }
            else if(i % 3 == 0) {
                s = "Fizz";
            }
            else if(i % 5 == 0) {
                s = "Buzz";
            }
            res.add(s);
        }
        
        return res;
    }
}
