// Link to problem - https://leetcode.com/problems/string-compression/description/


/**
 * Intuition - Scan the array and count the consecutive occurrences of character at i.
 * 'curr' pointer refers to the position at which we will write the unique character
 * followed by its count. Since 'count' can be 2000, use a string to store each place
 * in count. Otherwise, do modulus division and reverse the final count.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution {
    public int compress(char[] chars) {
        int curr = 0;   // Points to position where compressed character goes 
        int i = 0;

        while(i < chars.length) {
            int j = i + 1;
            int count = 1;

            // Add character at curr position, move curr to add count to next position
            chars[curr++] = chars[i];
            
            // Count consecutive occurrences of character at position i
            while(j < chars.length && chars[i] == chars[j]) {
                j++;
                count++;
            }
            i = j;  // Move to next unique character

            if(count > 1) {
                // Append count
                String countStr = Integer.toString(count);
                for(int m = 0; m < countStr.length(); m++) {
                    chars[curr++] = countStr.charAt(m);
                }
            }
        }

        return curr;
    }
}
