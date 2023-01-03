// Link to problem - https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

/**
 * Intuition - Compare the characters from haystack starting at pointer `start` with needle.
 * If an exact match is found, return `start`. While comparing characters, also store the
 * index of the first character which is the same as first character of needle to move the
 * start pointer to this position if needle is not found at current `start`.
 *
 * Time complexity - O(n)
 * Space cmplexity - O(1)
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int start = 0;
        int n;
        int next;

        while(start <= haystack.length() - needle.length()) {
            n = 0;
            next = -1;
            int begin = start;
            int end = begin;
            while(n < needle.length() && haystack.charAt(end) == needle.charAt(n)) {
                next = (next != -1 && haystack.charAt(end) == needle.charAt(0)) ? end : next;
                n++;
                end++;
            }
            if(end - begin == needle.length()) {
                return start;
            }
            else if(next != -1) {
                start = next;
            }
            else {
                start++;
            }
        }

        return -1;
    }
}


/**
 * Intuition - Use sliding window technique to find the 'needle' in 'haystack'.
 * The length of 'needle' becomes the window size. Store all unique characters
 * of needle in a set 'chars'.
 * Compare each element in the window with the 'needle'. If there's a match, then
 * continue until all elements from the window match and return 'left'.
 * Else, check if the current window element exists in 'chars' - 
 * If yes - slide window to the right by one position.
 * If not - slide window to the right of current element.
 *
 * Test cases for clarity - 
 * "sadbutsad"                    "sad"
 * "leetcode"                     "leeto"
 * "leetcode"                     "eetc"
 * "a"                            "a"
 * "aa"                           "a"
 * "aaa"                          "aa"
 * "aaaaaaaaaaaabcabcdddd"        "abcd"
 * "abzcbzaabbbbazbaabc"          "abc"
 * "abzcbzaabbbbazbaabbc"         "abc"
 * "abzcbzaabbbbazbaabbczabc"     "abc"
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public int strStr(String haystack, String needle) {
        Set<Character> chars = new HashSet<>();
        int left = 0;
        int right = needle.length() - 1;
        
        // Store all character from needle in Set
        for(int i = 0; i < needle.length(); i++) {
            chars.add(needle.charAt(i));
        }
        
        // Slide window of needle size through haystack and compare window with needle
        while(right < haystack.length()) {
            int i = left;
            int j = 0;
            while(i <= right) {
                if(haystack.charAt(i++) != needle.charAt(j++)) {
                    i--;
                    break;
                }
            }
            // If the element is not at index 0 and window elements matched with needle
            if(i > 0 && i - 1 == right) {
                return left;
            }
            // Element mismatch at index 0 or any other index where window element is in chars
            else if(i == 0 || chars.contains(haystack.charAt(i - 1))) {
                left++;
                right++;
            }
            // Window element is not in chars was found, so slide window to its right
            else {
                left = i + 1;
                right = left + needle.length() - 1;
            }
        }
        
        return -1;
    }
}
