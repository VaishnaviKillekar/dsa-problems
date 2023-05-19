// Link to problem - https://leetcode.com/problems/kth-largest-element-in-an-array/description/

/**
 * Intuition - Maintain a Priority Queue of size k and add elements
 * as scanned through the array. When size exceeds k, remove the head
 * which is the smallest element in the queue.
 * After all elements are scanned, return the head (kth largest)
 *
 * Time complexity - O(N lg K)
 * Space complexity - O(K)
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int num : nums) {
            queue.offer(num);

            if(queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }
}
