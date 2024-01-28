// Link to problem - https://www.codingninjas.com/studio/problems/k-th-largest-sum-contiguous-subarray_920398

/**
 * Intuition - Use a nxn loop to iterate through all possible subarrays.
 * Use a min heap of size k to store the sum of each subarray. Since min heap
 * stores the elements in ascending order, when we poll the top, the kth largest
 * sum or the smallest sum so far in heap is obtained.
 *
 * Time complexity - O(n^2)
 * Space complexity - O(k)
 */
public class Solution {

	public static int getKthLargest(ArrayList<Integer> arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		// Go through all possible subarrays
		for(int i = 0; i < arr.size(); i++) {
			int sum = 0;
			for(int j = i; j < arr.size(); j++) {
				sum += arr.get(j);
        // Maintain a min heap of size k
				if(minHeap.size() < k) {
					minHeap.add(sum);
				}
				else if(minHeap.peek() < sum) {
          // If current sum is greater than kth largest (top) so far, then replace
					minHeap.poll();
					minHeap.add(sum);
				}
			}
		}

		return minHeap.poll();
	}
}
