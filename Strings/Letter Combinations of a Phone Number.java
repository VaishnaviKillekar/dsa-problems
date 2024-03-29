// Link to problem - https://leetcode.com/problems/letter-combinations-of-a-phone-number/

/**
 * Intuition - BFS (Iterative)
 * Start with an empty linked list and continue appending characters for current digit to the first
 * combinations in the result 'combo' by removing it. Continue this until the length of the first
 * string combination in 'combo' is not equal to the number of digits.
 *
 * Time complexity - O(4^n) - n is the length of digits and each digit can have a maximum of 4 letters.
 * Space complexity - O(n) - could be constant
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letters = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> combos = new LinkedList<>();

        if(digits.length() == 0) {
            return combos;
        }
        
        // Initialise list with an empty string to begin with
        combos.add("");

        // Keep creating combinations until combo length becomes equal to number of digits
        while(combos.peek().length() != digits.length()) {
            // Get the first string in list
            String prefix = combos.remove();

            // Append current digit's letters to first string - use prefix length to get index
            String suffix = letters[digits.charAt(prefix.length()) - '0'];
            for(char c : suffix.toCharArray()) {
                combos.add(prefix + String.valueOf(c));
            }
        }

        return combos;
    }
}



/**
 * Intuition - Start with alphabets from the first digit and add them to the result.
 * Iterate through the result and append each aphabet of the next digit with all the 
 * alphabets in result.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        if(digits.length() == 0) {
            return res;
        }
        res.addAll(getChars(digits.charAt(0)));
        
        for(int i = 1; i < digits.length(); i++) {
            List<String> temp = new ArrayList<>();
            List<String> curr = getChars(digits.charAt(i));
            for(String r : res) {
                for(String c : curr) {
                    temp.add(r + c);
                }
            }
            res.clear();
            res.addAll(temp);
        }
        
        return res;
    }
    
    public List<String> getChars(char digit) {
        if(digit == '2') {
            return Arrays.asList("a", "b", "c");
        }
        else if(digit == '3') {
            return Arrays.asList("d", "e", "f");
        }
        else if(digit == '4') {
            return Arrays.asList("g", "h", "i");
        }
        else if(digit == '5') {
            return Arrays.asList("j", "k", "l");
        }
        else if(digit == '6') {
            return Arrays.asList("m", "n", "o");
        }
        else if(digit == '7') {
            return Arrays.asList("p", "q", "r", "s");
        }
        else if(digit == '8') {
            return Arrays.asList("t", "u", "v");
        }
        else {
            return Arrays.asList("w", "x", "y", "z");
        }
    }
}
