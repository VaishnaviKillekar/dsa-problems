/**
 * Intuition - Sort the array such that after every pass, the smallest element in the remaning
 * set of elements is placed at its correct position.
 *
 * Consider unsorted array [5,11,10,4,6,3,1]
 * Pass 1: [1,11,10,4,6,3,5]  (Swapped 1 and 5. 1 is now at its correct position)
 * Pass 2: [1,3,10,4,6,11,5]  (Swapped 3 and 11. 3 is now at its correct position)
 * Pass 3: [1,3,4,10,6,11,5]  (Swapped 4 and 10. 4 is now at its correct position)
 * Pass 4: [1,3,4,5,6,11,10]  (Swapped 5 and 10. 5 is now at its correct position)
 * Pass 5: [1,3,4,5,6,11,10]  (6 is already in its correct position. Move to next pass)
 * Pass 5: [1,3,4,5,6,10,11]  (Swapped 11 and 10. 10 is now at its correct position)
 * We know that the last element is also in its correct position.
 *
 * This is an unstable algorithm as it does not preserve the relative order of equal elements.
 * Consider for ex: [4 2 3 4 1]
 * The 4 at index 0 is swapped with 1. Hence, the first 4 is now moved after the second 4 and
 * their relative order has changed.
 *
 * Time complexity - O(n^2)
 * Space complexity - O(1)
 */
public class Solution {
	public static void selectionSort(int arr[], int n) {
		for(int i = 0; i < arr.length - 1; i++) {
			int smallest = i;
			int j;
			for(j = i + 1; j < arr.length; j++) {
				if(arr[smallest] > arr[j]) {
					smallest = j;
				}
			}
			swap(arr, i, smallest);
		}
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
