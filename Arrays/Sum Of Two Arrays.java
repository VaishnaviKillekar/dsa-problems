// Link to problem - https://www.codingninjas.com/codestudio/problems/sum-of-two-arrays_893186

/**
 * Intuition - Add elements from both arrays from the last index while
 * maintaining a carry. If after adding all elements, there is non-zero
 * carry, then increase array size by 1 and add carry at index 0. Otherwise,
 * return sum array.
 *
 * Time complexity - O(n + m)
 * Space complexity - O(n)
 */
public class Solution {
	public static int[] findArraySum(int[] a, int n, int[] b, int m) {
		int[] sum = new int[n > m ? n : m];
		int i = n - 1;
		int j = m - 1;
		int k = (n > m) ? n - 1 : m - 1;
		int carry = 0;

		while(i >= 0 && j >= 0) {
			int curr = a[i] + b[j] + carry;
			sum[k--] = curr % 10;
			carry = curr / 10;
			i--;
			j--;
		}

		while(i >= 0) {
			int curr = a[i] + carry;
			sum[k--] = curr % 10;
			carry = curr / 10;
			i--;
		}

		while(j >= 0) {
			int curr = b[j] + carry;
			sum[k--] = curr % 10;
			carry = curr / 10;
			j--;
		}

		if(carry == 0) {
			return sum;
		}

		int[] result = new int[sum.length + 1];
		result[0] = carry;
		System.arraycopy(sum, 0, result, 1, sum.length);
		return result;
	}
}
