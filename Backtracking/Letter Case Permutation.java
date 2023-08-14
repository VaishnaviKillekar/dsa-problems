// Link to problem - https://leetcode.com/problems/letter-case-permutation/

/**
 * Intuition - Similar approach as https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Add every combination to a linked list starting with empty string. Pick the head of the list as prefix and add
 * the current character to the prefix. If the character is a number, append to prefix and add to result. Otherwise,
 * add two combinations to the result - append prefix with upper case and lower case of current character.
 * Continue this process until the length of head of the list is not equal to length of given string s.
 *
 * Time complexity - O(2^n) - every character of s is a letter and there are two possibilities - uppercase, lowercase
 * Space complexity - O(1)
 */
class Solution {
    public List<String> letterCasePermutation(String s) {
        LinkedList<String> list = new LinkedList<>();
        list.add("");

        while(list.peek().length() != s.length()) {
            String prefix = list.removeFirst();
            int index = prefix.length();
            if(!Character.isDigit(s.charAt(index))) {
                list.add(prefix + Character.toUpperCase(s.charAt(index)));
                list.add(prefix + Character.toLowerCase(s.charAt(index)));
            }
            else {
                list.add(prefix + s.charAt(index));
            }
        }

        return list;
    }
}



/**
 * Intuition - Recursion with backtracking
 * Maintain an index which goes through each character and flips its case.
 *
 * Consider a1b2
 * Initially s is added to result = [a1b2]
 *
 * i = 0: result = [a1b2]                         -> flip, result = [a1b2, A1b2]
 * i = 1: result = [a1b2, A1b2]                   -> skip, result = [a1b2, A1b2]
 * i = 2: result = [a1b2, A1b2]                   -> flip, result = [a1b2, A1b2, a1B2, A1B2]
 * i = 3: result = [a1b2, A1b2, a1B2, A1B2]       -> skip, result = [a1b2, A1b2, a1B2, A1B2]
 * 
 * Time complexity - O(n * 2^n)
 * Space complexity - O(n)
 */
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        result.add(s);

        for(int i = 0; i < s.length(); i++) {
            permute(s, result, i);
        }

        return result;
    }

    public void permute(String s, List<String> result, int index) {
        if(Character.isDigit(s.charAt(index))) {
            return;
        }

        List<String> temp = new ArrayList<>();
        for(String str : result) {
            StringBuilder curr = new StringBuilder(str);
            if(Character.isLowerCase(curr.charAt(index))) {
                curr.setCharAt(index, Character.toUpperCase(curr.charAt(index)));
            }
            else {
                curr.setCharAt(index, Character.toLowerCase(curr.charAt(index)));
            }
            temp.add(curr.toString());
        }
        result.addAll(temp);
    }
}



/**
 * Intuition - Recursion with backtracking
 * Maintain an index which goes through each character and flips its case.
 *
 *           a1b2              i=0, when it's at a, since it's a letter, we have two branches: a, A
 *        /        \
 *      a1b2       A1b2        i=1, when it's at 1, we only have 1 branch which is itself
 *       |          |   
 *      a1b2       A1b2        i=2, when it's at b, we have two branches: b, B
 *      /  \        / \
 *     a1b2 a1B2  A1b2 A1B2    i=3,  when it's at 2, we only have one branch.
 *      |    |     |     |
 *     a1b2 a1B2  A1b2  A1B2   i=4, = S.length(). End recursion, add permutation to ans. 
 *     
 *     During this process, we are changing the S char array itself
 * 
 * Time complexity - O(n * 2^n)
 * Space complexity - O(n)
 */
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        permute(res, 0, s.toCharArray());
        return res;
    }
    
    public void permute(List<String> res, int i, char[] arr) {
        if(i == arr.length) {
            res.add(new String(arr));
        }
        else {
            if(Character.isDigit(arr[i])) {
                permute(res, i+1, arr);
            }
            else {
                arr[i] = Character.toUpperCase(arr[i]);
                permute(res, i+1, arr);
                arr[i] = Character.toLowerCase(arr[i]);
                permute(res, i+1, arr);
            }
        }
    }
}
