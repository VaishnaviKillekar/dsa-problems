// Link to problem - https://www.codingninjas.com/studio/problems/minimum-cost-to-make-string-valid_1115770

/**
 * Intuition - Use stack to remove balanced pairs of brackets from given string.
 * Now we are left with unbalanced part. Count the number of opening and closing
 * brackets. use the formula to compute the number of flips required to balance
 * these pairs.
 * Formula: (open + 1) / 2  +  (close + 1) / 2
 * String must contain even brackets as each balanced pair has 2.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
public class Solution {
    public static int findMinimumCost(String str) {
      // Odd length string can't have balanced brackets as each pair has 2
      if(str.length() % 2 == 1) {
        return -1;
      }

      // Even string - no. of opening = no. of closing
      Stack<Character> stack = new Stack<>();
      for(int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if(c == '{') {
          stack.push(c);
        }
        else {  // '}'
          if(!stack.isEmpty() && stack.peek() == '{') {
            // Balanced
            stack.pop();
          }
          else {
            // Not balanced
            stack.push(c);
          }
        }
      }

      // Get count of unbalanced opening and closing brackets
      int open = 0;
      int close = 0;
      while(!stack.isEmpty()) {
        char c = stack.pop();
        if(c == '{') {
          open++;
        }
        else {
          close++;
        }
      }

      // Unbalanced string is reduced to {{{.. or }}}... 
      // To balance them, we flip alternate brackets, the count is given by formula
      return ((open + 1) / 2) + ((close + 1) / 2);
    }
}
