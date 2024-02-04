// Link to problem - https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description

/**
 * Intuition - Start off with the first elements from k lists and add them to a min heap.
 * Get the min and max from the added elements. The lowest element from heap acts as min.
 * Since we need to get the lowest possible range, we need to shrink the range further.
 * This can be achieved by constantly removing min from heap and getting the next element 
 * of min. Since the next element from removed min will be smallest.
 * On adding a new element to heap, we check if new element is greater than max, if yes,
 * then update max. Continue this until the heap is empty or one of the k lists is
 * exhausted.
 *
 * Time complexity - O(k * n logk) - since heap contains k elements and takes logk time for polling and there are a total of n*k elements
 * Space complexity - O(k) - heap size
 */
class Solution {
    class HeapElement {
        int value;
        int list;
        int index;

        HeapElement() {}

        HeapElement(int value, int list, int index) {
            this.value = value;
            this.list = list;
            this.index = index;
        }
    }

    public class HeapComparator implements Comparator<HeapElement> {
        @Override
        public int compare(HeapElement a, HeapElement b) {
            if(a.value < b.value) {
                return -1;
            }
            else if(a.value > b.value) {
                return 1;
            }
            return 0;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<HeapElement> minHeap = new PriorityQueue<>(new HeapComparator());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Add all the first elements from k lists, track min and max
        for(int i = 0; i < nums.size(); i++) {
            HeapElement element = new HeapElement(nums.get(i).get(0), i, 0);
            minHeap.add(element);
            min = Math.min(min, element.value);
            max = Math.max(max, element.value);
        }

        // Get the start and end of range using new min and max
        int rangeStart = min;
        int rangeEnd = max;

        // Now we decrease the range using min as reference since max is already highest
        while(minHeap.size() > 0) {
            // Get least element in heap and decrease range
            HeapElement minElement = minHeap.poll();
            min = minElement.value;

            // Check if new range is smaller than previous
            if(max - min < rangeEnd - rangeStart) {
                rangeStart = min;
                rangeEnd = max;
            }

            // Add the next element of minElement for checking new range if it exists
            if(minElement.index + 1 < nums.get(minElement.list).size()) {
                HeapElement next = new HeapElement(nums.get(minElement.list).get(minElement.index + 1), 
                minElement.list, minElement.index + 1);
                minHeap.add(next);
                // Check if the new element is greater than current max
                max = Math.max(max, next.value);
            }
            else {
                // If all elements from any list are exhausted, then end the search
                break;
            }
        }

        return new int[] {rangeStart, rangeEnd};
    }
}
