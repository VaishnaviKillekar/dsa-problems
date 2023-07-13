// Link to problem - https://www.codingninjas.com/studio/problems/redundant-brackets_975473

/**
 * Intuition - A pair of brackets is redundant only when there aren't equal number of signs between them.
 * Push ( and signs onto stack. When a ) is found, pop elements from stack until ( is found.
 * If there were no signs between them, then expression is redundant.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
public class Solution 
{
    public static boolean findRedundantBrackets(String s) 
    {
        Stack<Character> stack = new Stack<>();
        int i = 0;

        while(i < s.length()) {
            char c = s.charAt(i++);
            if(c == '(' || c == '+' || c == '-' || c == '*' || c == '/') {
                stack.push(c);
            }
            else {
                if(c == ')') {
                    // Brackets should have a sign between them - check stack top
                    boolean isRedundant = true;
                    
                    // Now remove all signs until '('
                    while(stack.peek() != '(') {
                        if(stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/') {
                            isRedundant = false;
                        }
                        stack.pop();
                    }
                    stack.pop();    // Pop '('
                    if(isRedundant) {
                        return isRedundant;
                    }
                }
            }
        }
        return false;
    }
}
