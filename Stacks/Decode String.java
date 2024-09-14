// Link to problem - https://leetcode.com/problems/decode-string/description

/**
 * Intuition - Use a stack to store k and the substrings to be repeated along with opening brackets.
 * When a closing bracket is found while traversing the string, then pop all characters until an
 * opening bracket is found. Pop the oprning bracket and k, which could be multi-digit.
 * Push k repetitions of the substring back on to the stack and repeat until all characters are read.
 * Build the final string by popping all elements from stack.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i)) || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            else {
                // Closing bracket - decode substring
                String substr = new String();
                while(stack.peek() != '[') {
                    substr = stack.pop() + substr;
                }

                // Pop opening bracket
                stack.pop();

                // Pop k - this could be multi-digit number
                String num = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num = stack.pop() + num;
                }
                int k = Integer.parseInt(num);

                // Push substring k times on stack
                for(int j = 0; j < k; j++) {
                    for(int m = 0; m < substr.length(); m++) {
                        stack.push(substr.charAt(m));
                    }
                }
            }
        }

        String str = "";
        while(!stack.isEmpty()) {
            str = stack.pop() + str;
        }
        return str;
    }
}
