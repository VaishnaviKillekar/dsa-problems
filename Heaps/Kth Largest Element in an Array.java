// Link to problem - https://leetcode.com/problems/kth-largest-element-in-an-array/description/

/**
 * Intuition - Maintain a Priority Queue of size k which acts as a min heap (use comparator).
 * Add the first k elements from array into the queue. Now the remaining elements are to be
 * added one by one to the min heap if that element is greater than root. In this case, root
 * is removed from the min heap and current element is added. In this way, the root will
 * eventually become the kth largest element in queue.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a < b ? -1 : a == b ? 0 : 1;
            }
        });

        // Add the first k elements to min heap
        for(int i = 0 ; i < k; i++) {
            queue.offer(nums[i]);
        }

        // Add the remaining elements one by one if they are greater than root
        for(int i = k; i < nums.length; i++) {
            if(nums[i] > queue.peek()) {
                queue.poll();   // Remove root
                queue.offer(nums[i]);   // Add current
            }
        }

        return queue.poll();
    }
}



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
