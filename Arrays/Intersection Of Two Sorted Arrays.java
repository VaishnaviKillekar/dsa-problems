// Link to problem - https://www.codingninjas.com/codestudio/problems/intersection-of-2-arrays_1082149

/**
 * Intuition - Two-pointer approach
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 */
import java.util.* ;
import java.io.*; 
public class Solution
{
	public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m)
	{
		ArrayList<Integer> result = new ArrayList<>();
		int i = 0;
		int j = 0;

		while(i < n && j < m) {
			if(arr1.get(i).equals(arr2.get(j))) {
				result.add(arr1.get(i));
				i++;
				j++;
			}
			else if(arr1.get(i) < arr2.get(j)) {
				i++;
			}
			else {
				j++;
			}
		}

		return result;
	}
}
