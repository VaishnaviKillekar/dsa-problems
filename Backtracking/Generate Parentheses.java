// Link to problem - https://leetcode.com/problems/generate-parentheses/

/**
 * Intuition - Use backtracking to balance the number of parentheses.
 * Opening parentheses should be lower than given n and closing parentheses
 * must be equal to the number of opening parentheses.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "", 0, 0, n);
        return res;
    }
    
    public void generate(List<String> res, String str, int open, int close, int n) {
        if(str.length() == 2 * n) {
            res.add(str);
            return;
        }
        
        if(open < n) {
            generate(res, str + "(", open + 1, close, n);
        }
        if(close < open) {
            generate(res, str + ")", open, close + 1, n);
        }
    }
}
