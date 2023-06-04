/**
 * Intuition - The first part of array is maintained sorted and we pick one element
 * from the right, unsorted part and position it correctly in sorted part. In this
 * way, after every round i, we sort i elements in their right place.
 * In round i, we take the ith element and compare it with elements on its left
 * until i is smaller than i - 1 and so on. We find the index where it needs to
 * placed 'j' and shift all elements from 'j' to the right by one position.
 * 
 * Consider ex: [5,9,4,2,6]
 * Round 1: 9 > 5 => already sorted, move to next round                               [5, 9 | 4, 2, 6]
 * Round 2: 4 needs to be placed at index 0, shift 5 and 9 one position right         [4, 5, 9 | 2, 6]
 * Round 3: 2 needs to be placed at index 0, shift 4, 5, 9 one position right         [2, 4, 5, 9 | 6]
 * Round 4: 6 needs to be placed at index 3, shift 9 to one position right            [2, 4, 5, 6, 9 |]
 * The array is now fully sorted.
 * 
 * Insertion sort is a stable algorithm. It is also adaptive, i.e., it reduces its total number of steps 
 * if given a partially sorted list, hence it increases its efficiency.
 * 
 * Time complexity - O(n^2)
 * Space complexity - O(1)
 */
public class Solution {
	public static void insertionSort(int n , int[] arr) {
		for(int i = 1; i < n; i++) {
			int j = i - 1;
			if(arr[i] < arr[j]) {
				// Find the correct position of ith element
				while(j >= 0 && arr[i] < arr[j]) {
					j--;
				}
				j = j + 1;

				// Shift elements between i and j to the right by one position
				int temp = arr[i];
				int k = i;
				while(k > 0 && k >= j) {
					arr[k] = arr[k - 1];
					k--;
				}
				arr[j] = temp;
			}
		}
	}
}
