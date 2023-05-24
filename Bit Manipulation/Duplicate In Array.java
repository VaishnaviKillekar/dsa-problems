// Link to problem - https://www.codingninjas.com/codestudio/problems/duplicate-in-array_893397?leftPanelTab=0

/**
 * Intuition - Take an XOR of given array with elements 1 to N-1.
 * This will leave us with element that is repeated twice.
 * Consider N = 6 and given array, arr = {1,2,3,4,5,4}
 * Elements to XOR with arr = {1,2,3,4,5}
 * This will cancel out all unique elements as they appear twice.
 * But the element repeated twice in arr, will now appear thrice.
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
import java.util.ArrayList;

public class Solution {

	public static int findDuplicate(ArrayList<Integer> arr) {

		int xor = 0;

		for(int i = 0; i < arr.size(); i++) {
			xor = xor ^ arr.get(i);
		}

		for(int i = 1; i < arr.size(); i++) {
			xor = xor ^ i;
		}

		return xor;
	}
}
