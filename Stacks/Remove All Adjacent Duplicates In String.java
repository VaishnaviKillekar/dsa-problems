// Link to problem - https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/

/**
 * Intuition - Use stack to add characters from s. If stack top is not equal to incoming character,
 * then push the incoming character onto stack. Otherwise, skip this character andd pop the top to
 * remove the duplicate.
 * After going through all characters in s, finally build the result string using stack contents.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        String result = "";

        // Iterate through s and add characters to stack until stack top != incoming character
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(stack.size() > 0 && stack.peek() == curr) {
                // stack top == incoming character
                stack.pop();
            }
            else {
                // Push current character onto stack - stack is empty or stack top != incoming character
                stack.push(curr);
            } 
        }

        // Build string without dulicates using stack
        while(stack.size() > 0) {
            result = stack.pop() + result;
        }

        return result;
    }
}
