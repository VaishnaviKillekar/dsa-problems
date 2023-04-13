// Link to problem - https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

/**
 * Intuition - Use stack to store the operands and whenever an operator is found, pop
 * the top two elements from the stack and evaluate them. Push the result back onto
 * the stack and continue this from all the tokens.
 * After evaluating the entire token string, the result will be the only element on stack.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();

        for(String token : tokens) {
            if("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(evaluate(token.charAt(0), op1, op2));
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public int evaluate(Character token, int op1, int op2) {
        if(token == '+') {
            return op1 + op2;
        }
        else if(token == '-') {
            return op1 - op2;
        }
        else if(token == '*') {
            return op1 * op2;
        }
        else {
            return op1 / op2;
        }
    }
}
