// Link to problem - https://www.codingninjas.com/codestudio/problems/replace-spaces_1172172

/**
 * Intuition - Scan through the given string and when a space is found,
 * delete that space and add @40 at that index.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
public class Solution {
	public static StringBuilder replaceSpaces(StringBuilder str) {
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				// Replace space with @40
				str.deleteCharAt(i);
				str.insert(i, "@40");
			}
		}

		return str;
	}
}
