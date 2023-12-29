// Link to problem - https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1

/**
 * Intuition - To find the kth smallest element, we build a max heap with
 * the first k elements in the array. Then the remaining elements are scanned
 * and only those greater than the root of max heap are added such that the
 * root is removed and the new smaller element is added to get the kth smallest.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a > b ? -1 : a == b ? 0 : 1;
            }
        });

        // Add first k elements to heap
        for(int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        // Insert reamining elements to queue if they are greater than root
        for(int i = k; i < arr.length; i++) {
            if(arr[i] < queue.peek()) {
                queue.poll();   // Remove root - greatest element in heap
                queue.offer(arr[i]);    // Add current
            }
        }

        return queue.peek();
    }
}
