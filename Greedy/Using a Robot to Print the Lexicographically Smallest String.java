// Link to problem - https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/

/**
 * Intuition - Greedy + Stack
 * Stack is to be used to read in characters from s and print them to result
 * in last-in-first-out sequence as expected by Robot.
 * The solution is Greedy, as it compares current character with the lowest unread character each time - it optimises
 * the result as per the current condition.
 *
 * 1. Store the frequency of occurrence of characters in a 'freq' array.
 * 2. Read string 's' and push current character onto 'stack' and decrement its frequency by 1 in 'freq'.
 * 3. Compare the current character with the lowest character that is yet to be read.
 *    a. Until stack top is lower than or equal to the lowest unread character -> pop current and append to result.
 *    b. If stack top is greater than lowest unread character -> do nothing and move on to next character.
 * 4. Once all characters from s are read, pop all stack elements and append to 'res'.
 *
 * Test cases -
    "zza"
    "bac"
    "zzba"
    "zzdab"
    "zzdaabc"
    "bdda"
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */  
class Solution {
    public String robotWithString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int[] freq = new int[26];
        
        // Store occurrences of all characters
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        // Read s and store the characters on stack. Pop only if current is lowest than unread
        for(int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            freq[s.charAt(i) - 'a']--;
            
            // Pop characters from stack to result until they are lower than unread ones
            while(!stack.isEmpty() && stack.peek() <= getLowestRemainingChar(freq)) {
                res.append(stack.pop());
            }
        }
        
        // Pop remaining characters from stack
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }
        
        return res.toString();
    }
    
    public int getLowestRemainingChar(int[] freq) {
        for(int i = 0; i < 26; i++) {
            // Return the lowest character that is yet to be read
            if(freq[i] != 0) {
                return 'a' + i;
            }
        }
        return 'a';     // If no characters are left to be read
    }
}
