// Link to problem - https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/description/

/**
 * Intuition - Strings need to be compared lexicographically as "123" > "83". We use min heap to store all
 * strings one by one until the size of heap exceeds k. On exceeding k, we remove the root as it is the
 * smallest element in it and push the current string from array. This way, the root of the min heap will
 * hold the kth largest element.
 *
 * Time complexity - O(nlogk * m) - n is size of array, m is length of strings due to lexicographical comparison
 * Space complexity - O(k)
 */
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> queue = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if(a.length() < b.length()) {
                    return -1;
                }
                else if(a.length() > b.length()) {
                    return 1;
                }
                else {
                    return a.compareTo(b);
                }
            }
        });

        // Add elements to min heap
        for(int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if(queue.size() > k) {
                queue.poll();   // Remove root which is smallest element in heap
            }
        }

        return queue.peek();
    }
}
