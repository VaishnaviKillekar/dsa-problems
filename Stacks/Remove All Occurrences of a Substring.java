// Link to problem - https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/

/**
 * Intuition - Read characters from string 's' and add them to 'stack' until 'stack' size becomes
 * greater than or equal to 'part'. Then check if top elements of 'stack' contain 'part'. If yes,
 * then the top elements are popped. If not, add them back to stack.
 * Once all characters from 's' are read, then check the 'stack' top elements one more time to verify
 * if 'part' can be found. If not, then terminate search as 'stack' won't change and 'part' can't be
 * found. However, if 'part' is found, then continue search. This is achieved using 'stackChanged'.
 *
 * Time complexity - O(n^2) - check
 * Space complexity - O(n)
 */
class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();
        String result = "";
        int i = 0;
        boolean stackChanged = true;    // Used to check stack pop after s is fully read before terminating search

        while(i < s.length() || (stack.size() >= part.length()) && stackChanged) {
            if(stack.size() >= part.length()) {
                // Check if stack contains part
                String temp = "";
                for(int j = part.length() - 1; j >= 0; j--) {
                    char curr = part.charAt(j);
                    if(stack.peek() == curr) {
                        temp = curr + temp;
                        stack.pop();
                    }
                    else {
                        // Part not found - put back temp onto stack
                        int k = 0;
                        while(k < temp.length()) {
                            stack.push(temp.charAt(k++));
                        }
                        // If s is fully read, we need to check if stack contains part at top one last time.
                        // If not, then terminate search as stack won't be updated and part can't be found
                        if(i >= s.length()) {
                            stackChanged = false;
                        }
                        break;
                    }
                }
            }
            if(i < s.length()) {
                // Add current character to stack
                stack.push(s.charAt(i));
                i++;
            }
        }

        // Recreate leftover string using stack
        while(stack.size() > 0) {
            result = stack.pop() + result;
        }

        return result;
    }
}
