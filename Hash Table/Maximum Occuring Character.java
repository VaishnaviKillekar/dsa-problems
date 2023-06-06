// Link to problem - https://practice.geeksforgeeks.org/problems/maximum-occuring-character-1587115620/1

/**
 * Intuition - Store the number of occurrences of characters in map.
 * Iterate through map and get the lowest literal for max number of
 * occurrences.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution
{
    //Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String line)
    {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        char result = ' ';
        
        for(int i = 0; i < line.length(); i++) {
            Integer count = map.get(line.charAt(i));
            count = count == null ? 1 : count + 1;
            max = Math.max(max, count);
            map.put(line.charAt(i), count);
        }
        
        // get the max ocurring character
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max) {
                result = result != ' ' ? (result > entry.getKey() ? entry.getKey() : result) : entry.getKey();
            }
        }
        
        return result;
    }
}

/**
 * Intuition - Store the number of occurrences of characters in an array of size 26
 * where each index represents the alphabet with index 0 pointing to 'a'.
 * Iterate through given string 'line' and store the number of occurrences in the
 * corresponding index.
 * Now iterate through the alphabet array and find the maximum number of occurrences
 * and store that character. If max 'count' is common for more than one character,
 * then get the lowest literal.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
class Solution
{
    //Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String line)
    {
        int[] arr = new int[26];
        char maxChar = 'z';
        int count = 0;
        
        for(int i = 0; i < line.length(); i++) {
            arr[line.charAt(i) - 'a']++;
        }
        
        // get the max ocurring character
        for(int i = 0; i < 26; i++) {
            if(arr[i] > count) {
                maxChar = (char) (i + 'a');
                count = arr[i];
            }
            else if (arr[i] == count && ((char) (i + 'a') < maxChar)) {
                maxChar = (char) (i + 'a') < maxChar ? (char) (i + 'a') : maxChar;
            }
        }
        
        return maxChar;
    }
    
}
