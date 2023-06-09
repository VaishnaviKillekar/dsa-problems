// Link to problem - https://www.codingninjas.com/codestudio/problems/print-like-a-wave_893268

/**
 * Intuition - To print the 2D array as a sine wave, 
 * Even indices - top to bottom
 * Odd indices - bottom to top
 * This can be tracked using a boolean variable 'up' which is flipped after a column is read.
 *
 * Time complexity - O(m * n)
 * Space complexity - O(1)
 */
public class Solution {
	public static int[] wavePrint(int arr[][], int nRows, int mCols) {
		int[] sine = new int[nRows * mCols];
		int k = 0;
		boolean up = false;		// Denotes if we need to go up or down a column

		for(int j = 0; j < mCols; j++) {
			if(up) {
				// Rows need to be read upward
				for(int i = nRows - 1; i >= 0; i--) {
					sine[k++] = arr[i][j];
				}
			}
			else {
				// Rows need to be read downward
				for(int i = 0; i < nRows; i++) {
					sine[k++] = arr[i][j];
				}
			}
			up = !up;	// Reverse up after going through the column
		}

		return sine;
	}
}


